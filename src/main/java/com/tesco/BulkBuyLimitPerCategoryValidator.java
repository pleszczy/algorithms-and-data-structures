package com.tesco;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class BulkBuyLimitPerCategoryValidator implements Validator {
  private final Map<Category, Integer> limitPerCategory;

  public BulkBuyLimitPerCategoryValidator(Map<Category, Integer> limitPerCategory) {
    this.limitPerCategory = limitPerCategory;
  }

  @Override
  public void validate(List<Product> cart) {
    Map<Category, List<Product>> productsPerCategory = cart.stream()
        .collect(Collectors.groupingBy(Product::category));

    limitPerCategory.forEach((category, maxQuantity) -> {
      var totalAmountOfProducts = productsPerCategory
          .getOrDefault(category, List.of())
          .stream()
          .mapToInt(Product::quantity)
          .sum();

      if (totalAmountOfProducts > maxQuantity) {
        throw new IllegalArgumentException("Category " + category + " has exceeded maximum quantity of " + maxQuantity);
      }
    });
  }
}
