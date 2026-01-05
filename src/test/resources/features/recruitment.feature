Feature: Recruitment Module

  Scenario: Add candidate without uploading document
    Given user opens OrangeHRM application
    When user enters username and password
    And user clicks login button
    And user navigates to Recruitment module
    And user adds a new candidate without document upload
    Then candidate should be added successfully


  Scenario: Add vacancy using existing job title
    Given user opens OrangeHRM application
    When user enters username and password
    And user clicks login button
    And user navigates to Recruitment module
    And user navigates to Vacancies section
    And user adds a new vacancy using existing job title
    Then vacancy should be created successfully
