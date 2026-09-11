@Regression @UI @Cart
Feature: Cart Feature

  In order to manage the products I want to purchase
  As a user
  I want to be able to add, remove and review products in my cart

  Background:
    Given user has opened the application
    And user is logged-in as "Standard User"

  @Cart-01
  Scenario: Add product to cart - from Product List page
    When user adds a product to the cart
    Then cart icon displays a quantity of 1
    And product is added to the cart

  @Cart-02
  Scenario: Add product to cart - from Product Details page
    Given user is in "Product Details" page
    When user adds the product to the cart
    Then cart icon displays a quantity of 1
    And product is added to the cart

  @Cart-03
  Scenario: Remove product from cart
    Given user has added some products to the cart
    And user is in "Cart" page
    When user removes a product from the cart
    Then product is removed from the cart
    And cart quantity is decreased by 1

  @Cart-04
  Scenario: Remove all products from cart
    Given user has added some products to the cart
    And user is in "Cart" page
    When user removes all products from the cart
    Then the cart is empty
    And cart icon does not display a quantity

  @Cart-05
  Scenario: Cart - Continue shopping
    Given user has added some products to the cart
    And user is in "Cart" page
    When user selects "Continue Shopping"
    Then user is redirected to "Product List" page