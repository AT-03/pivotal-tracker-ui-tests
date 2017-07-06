Feature: Update delete

  Background:
    When I request "POST" "/my/workspaces" with:
      | name | TestWorkSpaces |
    And I stored as [TestWorkSpaces]

  @login @deleteWorkspace @goToDashboard
  Scenario: Update a Workspace
    When I navigate dashboard workspace and update the "TestWorkSpaces" with "WorkspaceNameChanged"
    Then Confirm message should be "Changes saved."
    And project name should be "WorkspaceNameChanged"
    And I stored as [WorkspaceUI]
    Then "WorkspaceNameChanged" should be displayed
    Then "TestWorkSpaces" should not be displayed

 
  @login @deleteWorkspace @goToDashboard
  Scenario: Update a workspace with a name that already exit.
    Given I request "POST" "/my/workspaces" with:
      | name | TestWorkSpaces1 |
    When I navigate dashboard workspace and update the "TestWorkSpaces1" with "TestWorkSpaces"
    And I stored as [WorkspaceUI]
    Then  Error message above should be "The workspace name you entered is already taken."
    And  Error message below shoud be "Error: Please check your changes and try saving again."

  @login @goToDashboard
  Scenario: Delete a workspace
    When I navigate dashboard workspace and delete the "TestWorkSpaces"
    Then Message should be "TestWorkSpaces was successfully deleted."
    Then "TestWorkSpace" should not be displayed






