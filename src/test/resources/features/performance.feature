Feature: Validate Performance module sections

  Scenario: Validate all Performance sub menus
    Given user opens OrangeHRM application
    When user enters username and password
    And user clicks login button
    Then user should see dashboard
    When user navigates to Performance module
    Then user should be able to view all Performance sections
