Feature: Update and delete accounts

  Background:
    When  I navigate to accounts
    And I create a new accounts AutomationTestAT01-03

  @login @deleteAllProjects @deleteAllAccounts
  Scenario: Update a account
    When I navigate account Settings
    And I update the next account AutomationTestAT01-03 with "AutomationTestAT01-03 Update"
    Then "Successfully changed account settings." should be displayed accounts

  @login @deleteAllAccounts
  Scenario: Delete a accounts
    When I navigate account Settings
    Then Message should be account "AutomationTestAT01-03 was successfully deleted."