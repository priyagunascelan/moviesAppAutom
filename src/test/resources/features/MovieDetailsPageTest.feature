Feature: Test  Movie Details Section
  As a user of the Movies App
  I want to check Movie details Page
  So that I can view result


  Scenario: Test the Movie Details Section
    Given I am on the login page
    When I Login with valid UserID and password
    But I should be redirected to the homepage
    And I am in the Home Page click on any Movie and test all the UI elements present in it
    Then I am in the Popular Page click on any Movie and test all the UI elements present in it






