Feature: Create Project with a account

  @loginAt03 @deleteProject @deleteAllAccounts
  Scenario: Verify if we create a new project with setting by default.
  New account is create and privacy is private.
    When I added a new project
      | PROJECT_NAME | Automation Project Test 01 |
      | ACCOUNT      | AutomationTestAT03-01      |
    Then Verify that a new project is created
    And  Verify the new account with his project


  @deleteAllProjects @deleteAllAccounts
  Scenario: Create a new project when Project privacy is public and the account exist
    When I create a new account AutomationTestAT01-03
    And I added a new project
      | PROJECT_NAME    | Automation Project Test 01 |
      | ACCOUNT         | AutomationTestAT01-03      |
      | PROJECT_PRIVACY | Public                     |
    Then Verify that a new project is created
    And  Verify the new account with his project

  @deleteAllProjects @deleteAllAccounts
  Scenario:Create a new project when Project and  account are empty
    When I added a new project
      | PROJECT_PRIVACY | Public |
    Then The project should to message as "Enter a name for your project" and the account "Please select or create an account for the new project"
