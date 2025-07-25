Feature: Login related scenarios

  Background:
    #Given user is able to access HRMS application
    #this is a pre condition commented out due to Hooks is handle it
@sprint1 @smoke @regression @diana @valid
  Scenario: Valid admin login
    When user enters valid username and password
    And user clicks on login button
    Then user is able to see dashboard page

  @error @diana
    Scenario: Invalid admin login
    When user enters invalid username and password
    And user clicks on login button
    Then user can see error message






