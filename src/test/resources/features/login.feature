@Regression @UI @Login
Feature: Login Feature

  In order to access the application
  As a user
  I want to be able to log in and log out

  Background:
    Given user has opened the application

  @Login-01
  Scenario Outline: Login - Successful - <user_type>
    When user logs in as "<user_type>"
    Then user is presented with "Product List" Page
    Examples:
      | user_type               |
      | Standard User           |
      | Problem User            |
      | Performance Glitch User |
      | Error User              |
      | Visual User             |

  @Login-02
  Scenario: Login with locked user
    When user logs in as "Locked out User"
    Then user is presented with the message "Sorry, this user has been locked out"

  @Login-03
  Scenario: Login with invalid credentials
    When user logs in with invalid credentials
    Then user is presented with the message "Username and password do not match any user in this service"

  @Login-04
  Scenario: Logout
    Given user is logged-in as "Standard User"
    When user logs out
    Then user is redirected to "Login" page