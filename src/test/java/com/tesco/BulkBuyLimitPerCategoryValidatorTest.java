package com.tesco;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BulkBuyLimitPerCategoryValidatorTest {

  @Test
  void should_not_allow_more_items_per_category_then_its_allowed() {
    Map<Category, Integer> categoryToMaxQuantity = Map.of(Category.PARACETAMOL, 5);
    var systemUnderTest = new BulkBuyLimitPerCategoryValidator(categoryToMaxQuantity);
    var cart = List.of(
        new Product("ibbuprem", Category.PARACETAMOL, 4),
        new Product("parcetamol", Category.PARACETAMOL, 2)
    );

    assertThrows(
        IllegalArgumentException.class,
        () -> systemUnderTest.validate(cart)
    );
  }

}