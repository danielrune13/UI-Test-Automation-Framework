Feature: Test Feature

  @UI
  Scenario Outline: Login - Successful
    Given user opens the application
    When user logs in as "<userType>"
    Then user is presented with the Product List Page
    Examples:
      | userType                |
      | Standard User           |
      | Problem User            |
      | Performance Glitch User |
      | Error User              |
      | Visual User             |