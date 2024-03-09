Feature: Test Home page
  As a user of the Movies App
  I want to check whether the Movies are displayed
  So that I can play the movie

  Scenario: Test the Home Page
    Given I am on the login page
    When I Login with valid UserID and password
    Then I should be redirected to the homepage
    When I test the heading texts of each section
    And I test whether the play button is displayed or not
    But I test whether the Movies are displayed, in the corresponding movies sections
    Then I test the Contact Us Section