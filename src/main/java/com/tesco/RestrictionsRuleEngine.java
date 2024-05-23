package com.tesco;

import java.util.List;
import java.util.Set;

/**
 * Tesco gets millions of orders every day with an average basket size of 100 items. Tesco Business has got some regulations around selling products online and in stores. These regulations are mandatory from legal and business perspective to enforce for all order transactions.
 * <p>
 * You are given an order with a list of products in the shopping cart/basket with productid, product Category and quantity. And also, Restriction Rules on Qty and Qty/Category.
 * <p>
 * Example:
 * <p>
 * Ordered items in the shopping cart/basket
 * <p>
 * Item-1 -> productid=1, category=Paracetamol, quantity=3
 * <p>
 * Item-2 -> productid=2, category=analgesic, quantity=3
 * <p>
 * Item-3 -> productid=3, category=chocolate, quantity=8
 * <p>
 * Item-4 -> productid=4, category= Paracetamol, quantity=2
 * <p>
 * Business Restriction rules:
 * <p>
 * Cannot buy more than 10 Quantity of any products - BulkBuyLimit
 * <p>
 * Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory
 * <p>
 * Write a restriction rule engine to run the restriction check against the shopping cart/basket and return the status as to MET/BREACHED indicating restriction status for the given restriction rules.
 * <p>
 * For the above given example, the restriction status returned would be MET.
 * <p>
 * Assumptions:
 * - cart can contain multiply items of the same category
 * - cart cant contain duplicate products
 * - tests should check the validation message
 * - create dedicated packages per functionality e.g. model / validators etc
 * <p>
 *  TODO:
 *   - custom exception
 *   - change the engine to work like e.g. assertAll instead of just fail fast validation
 */
public class RestrictionsRuleEngine {
  private final Set<Validator> validators;

  public RestrictionsRuleEngine(Set<Validator> validators) {
    this.validators = validators;
  }

  public RestrictionStatus verifyRestrictions(List<Product> cart) {
    try {
      validators.forEach(it -> it.validate(cart));
    } catch (IllegalArgumentException ex) {
      return RestrictionStatus.BREACHED;
    }
    return RestrictionStatus.MET;
  }
}
