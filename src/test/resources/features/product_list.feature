@Regression @UI @ProductList
Feature: Product List Feature

  In order to find and select products
  As a user
  I want to be able to browse, sort and view product details

  Background:
    Given user has opened the application
    And user is logged-in as "Standard User"

  @ProductList-01
  Scenario Outline: Sort products - "<sort_type>"
    When user sorts the products by "<sort_type>"
    Then products are sorted by "<sort_type>"
    Examples:
      | sort_type           |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  @ProductList-02
  Scenario: Sidebar - All Items
    Given user is in "Cart" page
    When user selects "All Items" from the sidebar menu
    Then user is redirected to "Product List" page

  @ProductList-03
  Scenario Outline: Open product details
    When user selects a product using its "<product_element>"
    Then user is redirected to "Product Details" page
    And the following product information is provided
      | Name | Image | Description | Price | Add to cart |
    Examples:
      | product_element |
      | product title   |
      | product image   |