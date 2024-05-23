package com.tesco;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class BulkBuyLimitValidatorTest {

  @Test
  void should_not_allow_more_items_then_the_max() {
    var systemUnderTest = new BulkBuyLimitValidator(10);
    var cart = List.of(
        new Product("mocne", Category.CHOCOLATE, 10),
        new Product("parcetamol", Category.PARACETAMOL, 11)
    );

    assertThrows(
        IllegalArgumentException.class,
        () -> systemUnderTest.validate(cart)
    );
  }
}