Feature: Test Search page Section
  As a user of the Movies App
  I want to check Search Page
  So that I can view result


  Scenario: Test the Search Functionality
    Given I am on the login page
    When I Login with valid UserID and password
    And I should be redirected to the homepage
    Then I searching with a movie name and the count of movies displayed


