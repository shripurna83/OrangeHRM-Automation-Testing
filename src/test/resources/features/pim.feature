Feature: PIM Add Employee

  Scenario: Add a new employee in PIM
    Given user opens OrangeHRM application
    When user enters username and password
    And user clicks login button
    Then user should see dashboard
    When user navigates to PIM
    And user adds a new employee
    Then employee should be created successfully
