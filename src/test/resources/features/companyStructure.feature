@CRMLYEUG-1441

Feature:User should be able to use the functions on Company Structure
  User Story:US05_As a user, I should be able to use functions on Company Structure under Employee menu

#--------------------------------A.C->1---------------------------------------
  @CRMLYEUG-1401
  Scenario Outline:All user types should be able to display company structure.
    Given user is on login page
    When User enter username"<username>" and password "<password>"
    And User is on home page and clicks employee button
    Then User should see company structure
    Examples:
    |username                     | password|
    |hr2@cybertekschool.com       | UserUser|
    |helpdesk1@cybertekschool.com | UserUser|
    |marketing1@cybertekschool.com| UserUser|
#-------------------------------A.C->2---------------------------------------
  @CRMLYEUG-1404
  Scenario:Hr user should be able to add a department from the company structure
    Given Hr user is on the employees page
    When Hr user click department add button
    And Hr user type a department name
    Then Hr user should add that department
  @CRMLYEUG-1406
  Scenario:Hr user should see warning message without typing
    Given Hr user is on the employees page
    When Hr user click department add button
    And Hr user doesn't type a department name
    Then Hr user should see warning message

#-------------------------------A.C->3---------------------------------------
  @CRMLYEUG-1407
  Scenario: Hr user should be able to select a parent department from the department dropdown.
    Given Hr user is on the employees page
    When Hr user click department add button
    And Hr user type a department name
    And Hr user select a parent department from dropdown
    Then Hr user should  add that department as it's parent department

#-------------------------------A.C->4---------------------------------------
  @CRMLYEUG-1408
  Scenario: Hr user should be able to select a supervisor from "recent"
    Given Hr user is on the employees page
    When Hr user click department add button
    And Hr user select a supervisor "Kadir Testa" from recent
    Then Hr user should see "Kadir Testa" as supervisor from recent
  @CRMLYEUG-1409
  Scenario: Hr user should be able to select a supervisor from "company"
    Given Hr user is on the employees page
    When Hr user click department add button
    And Hr user select a supervisor from company
    Then Hr user should see that name as supervisor from company
  @CRMLYEUG-1410
  Scenario: Hr user should be able to select a supervisor from "search"
    Given Hr user is on the employees page
    When Hr user click department add button
    And Hr user select a supervisor "Arben Istrefi" from search
    Then Hr user should see "Arben Istrefi" as supervisor from search
#-------------------------------A.C->5---------------------------------------
  @CRMLYEUG-1435
  Scenario: Hr user should be able to close add department pop-up at any time before sending
    Given Hr user is on the employees page
    When Hr user click department add button
    And Hr user click the closing sign
    Then Hr user should closed the pop-up
#-------------------------------A.C->6--------------------------------------
  @CRMLYEUG-1436
  Scenario:Hr user should be able to edit departments
    Given Hr user is on the employees page
    When Hr user click a department "QA Dept." from company structure
    And Hr user click edit department button
    Then Hr user should edit department
  @CRMLYEUG-1437 @Smoke
  Scenario:  Hr user should be able to add child departments
    Given Hr user is on the employees page
    When Hr user click a department "QA Dept." from company structure
    And Hr user click add department button
    Then Hr user should add a child department
  @CRMLYEUG-1438 @Smoke
  Scenario: Hr user should be able to delete departments after adding the department.
    Given Hr user is on the employees page
    When Hr user click a department "QA Dept." from company structure
    And Hr user click a department under QA department
    And Hr user click delete department button
    Then Hr user should not see  the deleted department in company structure
#-------------------------------A.C->7--------------------------------------
  @CRMLYEUG-1439
  Scenario: Hr user should be able to drag and drop the existing department under another department as a subdepartment
    Given Hr user is on the employees page
    When Hr user drag and drop a department under another department
    Then Hr user should see this department as subdepartment of that department
    #-------------------------------A.C->8--------------------------------------
  @CRMLYEUG-1440
  Scenario Outline:  Helpdesk and marketing users can not change company structure.
    Given Helpdesk and marketing users are on login page
    When Helpdesk and marketing users enter username"<username>" and password "<password>"
    And Helpdesk and marketing users are on home page and click employees button
    Then Helpdesk and marketing users should not be able to see add department button
    Examples:
      |username                     | password|
      |helpdesk1@cybertekschool.com | UserUser|
      |marketing1@cybertekschool.com| UserUser|












