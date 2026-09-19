@Regression @UI @Checkout
Feature: Checkout Feature

  In order to complete my purchase
  As a user
  I want to be able to provide my information, review my order and complete checkout

  Background:
    Given user has opened the application
    And user is logged-in as "Standard User"
    And user has added some products to the cart

  @Checkout-01
  Scenario: Start checkout
    Given user is in "Cart" page
    When user starts the checkout
    Then user is redirected to "Checkout: Your Information" page
    And the following information is requested by the system
      | First Name | Last Name | Zip/Postal Code |

  @Checkout-02
  Scenario: "Checkout: Your Information" page - Cancel checkout
    Given user has started the checkout process
    When user cancels the checkout
    Then user is redirected to "Cart" page

  @Checkout-03
  Scenario Outline: Checkout without providing "<personal_information>"
    Given user has started the checkout process
    When user submits checkout information without providing "<personal_information>"
    Then user is presented with the message "<message>"
    Examples:
      | personal_information | message                 |
      | First Name           | First Name is required  |
      | Last Name            | Last Name is required   |
      | Zip/Postal Code      | Postal Code is required |

  @Checkout-04
  Scenario: Submit personal information
    Given user has started the checkout process
    When user submits checkout information
    Then user is redirected to "Checkout: Overview" page
    And the following checkout information is provided
      | Products | Payment Information | Shipping Information | Total Price |

  @Checkout-05
  Scenario: "Checkout: Overview" page - Cancel
    Given user is in "Checkout: Overview" page
    When user cancels the checkout
    Then user is redirected to "Product List" page

  @Checkout-06
  Scenario: Finish checkout
    Given user is in "Checkout: Overview" page
    When user finishes the checkout
    Then user is redirected to "Checkout: Complete!" page
    And cart icon does not display a quantity
    And the message "Your order has been dispatched" is provided
    And the following options are available
      | Back Home | Generate PDF Order |

  @Checkout-07
  Scenario: Return home after completing checkout
    Given user is in "Checkout: Complete!" page
    When user selects to return back to home
    Then user is redirected to "Product List" page

  @Checkout-08
  Scenario: Generate PDF order confirmation
    Given user is in "Checkout: Complete!" page
    When user selects to generate the PDF Order
    Then a PDF document is downloaded
    And the document contains the following information
      | Order Date | Shipping Address | Items | Price |