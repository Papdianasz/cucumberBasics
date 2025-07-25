Feature: Add Employee

  Background:
    #Given user is able to access HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on om PIM option
    And user clicks on Add employee option

@sprint1 @melissa
  Scenario: Adding the employee
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

 @sprint2 @smoke @regression @melissa
    Scenario: Adding the employee by firstname middleName and lastname
      And user enters firstname and middlename and lastname
      And user clicks on save button
      Then employee added successfully

  @params
  Scenario: Adding employee using parameters
    And user enters "Zsuzsanna" and "Krisztina" and "Kovács" in the application
    And user clicks on save button
    Then employee added successfully

@example
    Scenario Outline: adding multiple employees
      And user add "<firstName>" , "<middleName>" , "<lastName>"
      And user clicks on save button
      Then employee added successfully
      Examples:
        | firstName | middleName | lastName |
        |Adam       |ms          |Doe       |
        |mark       |ms          |Somebody  |
        |Pál        |Inka        |Szerelmem |

@data
  Scenario: adding multiple employees using data table
    When users adds multiple employees using data table and save them
    |firstName  |middleName  |lastName  |
    |Anna       |Karina      |Dobos     |
    |Marianna   |Edina       |Solymos   |
    |Pál        |Inka        |Szerelmem |

@excel
  Scenario: adding employees using excel file
    When  user adds multiple employees from excel file