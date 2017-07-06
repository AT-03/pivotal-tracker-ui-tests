Feature: create a workspace

  @login @goToDashboard
  Scenario: create
    When  I navigate to dashboard workspace
    And create a new worksapce as:
      | Name | MyWorkspaceTest |
    Then "MyWorkspaceTest" should be displayed in dashboard workspace

  @login @goToDashboard
  Scenario: Create a workspace leaving the name field in blank

    When I navigate to dashboard workspace
    And create a new worksapce as:
      | Name |  |
    Then  Error message should be "Workspace name can't be blank."

  @login @goToDashboard
  Scenario: Create a workspace with name already exist
    When  I navigate to dashboard workspace
    And create a new worksapce as:
      | Name | MyWorkspaceTest |
    Then  Error message must be "The workspace name you entered is already taken."
