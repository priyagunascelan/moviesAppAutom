Feature: Test Header Section
  As a user of the Movies App
  I want to check popular page UI
  So that I can view result


  Scenario: Test the Popular page
    Given I am on the login page
    When I Login with valid UserID and password
    And I should be redirected to the homepage
    Then I Test whether the popular movies are displayed