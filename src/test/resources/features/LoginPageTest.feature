Feature: Test login page
  As a user of the Movies App
  I want to check Logo is displayed and enter username and password
  So that I can view result

  Scenario: Test the Login page
    Given I am on the login page
    When I Test the Login Page UI
    When I Login with empty input fields
    And I Login with empty User name field
    And I Login with empty password field
    But I Login with invalid password
    Then I Login with valid UserID and password

