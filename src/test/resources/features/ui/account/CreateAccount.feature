Feature: Create Account

  @login @goToDashboard @deleteAllProjects
  Scenario: Create a new Account
    When  I navigate to accounts
    And I create a new accounts AutomationTestAT01-03
    Then "AutomationTestAT01-03" should be displayed in account details