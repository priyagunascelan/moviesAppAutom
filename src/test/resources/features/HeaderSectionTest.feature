Feature: Test Header Section
  As a user of the Movies App
  I want to check Header UI and Header section functionality
  So that I can view result


  Scenario: Test the Header Section
    Given I am on the login page
    When I Login with valid UserID and password
    Then I should be redirected to the homepage
    When I test the logo is display
    And I test Navbar elements present
    Then I have validate the url page

