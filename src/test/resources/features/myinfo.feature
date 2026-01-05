Feature: My Info section validation

  Scenario: Validate all My Info sub sections
    Given user opens OrangeHRM application
    When user enters username and password
    And user clicks login button
    Then user should see dashboard
    When user navigates to My Info module
    Then user should be able to view all My Info sections
