package com.tesco;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RestrictionsRuleEngineTest {

  private static Set<Validator> getValidators() {
    var bulkValidator = new BulkBuyLimitValidator(10);
    var categoryToMaxQuantity = Map.of(Category.PARACETAMOL, 5);
    var bulkBuyPerCategory = new BulkBuyLimitPerCategoryValidator(categoryToMaxQuantity);
    return Set.of(bulkValidator, bulkBuyPerCategory);
  }

  @Test
  void should_verify_restrictions_on_bulk_orders() {
    var bulkValidator = new BulkBuyLimitValidator(10);
    var systemUnderTest = new RestrictionsRuleEngine(Set.of(bulkValidator));
    var cart = List.of(
        new Product("mocne", Category.CHOCOLATE, 10),
        new Product("parcetamol", Category.PARACETAMOL, 11)
    );

    var actualStatus = systemUnderTest.verifyRestrictions(cart);

    assertThat(actualStatus).isEqualTo(RestrictionStatus.BREACHED);
  }


//   * Ordered items in the shopping cart/basket
// *
//     * Item-1 -> productid=1, category=Paracetamol, quantity=3
//      *
//      * Item-2 -> productid=2, category=analgesic, quantity=3
//      *
//      * Item-3 -> productid=3, category=chocolate, quantity=8
//      *
//      * Item-4 -> productid=4, category= Paracetamol, quantity=2

  @Test
  void should_verify_restrictions_on_bulk_orders_per_category() {
    var systemUnderTest = new RestrictionsRuleEngine(getValidators());
    var cart = List.of(
        new Product("ibbuprom", Category.PARACETAMOL, 1),
        new Product("parcetamol", Category.PARACETAMOL, 5)
    );

    var actualStatus = systemUnderTest.verifyRestrictions(cart);

    assertThat(actualStatus).isEqualTo(RestrictionStatus.BREACHED);
  }

  @Test
  void should_postivly_validate_bulk_order() {
    var systemUnderTest = new RestrictionsRuleEngine(getValidators());
    var cart = List.of(
        new Product("1", Category.PARACETAMOL, 3),
        new Product("2", Category.ANALGESIC, 3),
        new Product("3", Category.CHOCOLATE, 8),
        new Product("4", Category.PARACETAMOL, 2)
    );

    var actualStatus = systemUnderTest.verifyRestrictions(cart);

    assertThat(actualStatus).isEqualTo(RestrictionStatus.MET);
  }
}