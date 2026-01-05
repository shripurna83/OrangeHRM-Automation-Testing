Feature: Login functionality

  Scenario: Login with valid credentials
    Given user opens OrangeHRM application
    When user enters username and password
    And user clicks login button
    Then user should see dashboard
    Then user should see all left side menu options
    Then user clicks each left menu and validates page header



