Feature: Update delete

  Background:
    Given I login to pivotal as "User1"
    When I request "POST" "/my/workspaces" with:
      | name | TestWorkSpaces |
    And I stored as [TestWorkSpaces]

  @deleteWorkspace
  Scenario: Update a Workspace
    When I navigate dashboard workspace and update the "TestWorkSpaces" with "WorkspaceNameChanged"
    Then Confirm message should be "Changes saved."
    And project name should be "WorkspaceNameChanged"
    And I stored as [WorkspaceUI]
    And "WorkspaceNameChanged" should be displayed
    And "TestWorkSpaces" should not be displayed

  Scenario: Delete a workspace
    When I navigate dashboard workspace and delete the "TestWorkSpaces"
    Then Message should be "TestWorkSpaces was successfully deleted."
    And "TestWorkSpace" should not be displayed

  @deleteWorkspace
  Scenario: Update a workspace with a name that already exit.
    Given I request "POST" "/my/workspaces" with:
      | name | TestWorkSpaces1 |
    When I navigate dashboard workspace and update the "TestWorkSpaces1" with "TestWorkSpaces"
    And I stored as [WorkspaceUI]
    Then  Error message above should be "The workspace name you entered is already taken."
    And  Error message below shoud be "Error: Please check your changes and try saving again."

#  @deleteWorkspace
#  Scenario:Add project in a workspace
#    When I navigate to  workspace on the dashboard and i select a workspace
#    And I stored as [WorkspaceUI]
#    And I add multiple projects on "TestWorkSpaces"
#      | Demo Automation | Demo GUI Automation | Demo AT 03 |




