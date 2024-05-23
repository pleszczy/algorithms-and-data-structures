package com.tesco;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class BulkBuyLimitValidator implements Validator {

  private final int maxBulk;

  public BulkBuyLimitValidator(int maxBulk) {
    this.maxBulk = maxBulk;
  }

  @Override
  public void validate(List<Product> cart) {
    cart.forEach(it -> {
      if (it.quantity() > maxBulk) {
        throw new IllegalArgumentException("Maximum quantity is " + maxBulk + " but " + it.productId() + " is " + it.quantity());
      }
    });
  }
}
