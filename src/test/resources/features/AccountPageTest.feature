Feature: Test Account Page Section
  As a user of the Movies App
  I want to check Movie details Page
  So that I can view result


  Scenario: Test Account Page
    Given I am on the login page
    When I Login with valid UserID and password
    But I should be redirected to the homepage
    And I test all the UI elements present on the web page
    Then I Test the Logout functionality