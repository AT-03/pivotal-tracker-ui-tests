Feature: create a workspace


  Scenario: create
    When  I navigate to dashboard workspace and create a new worksapce as:
      | Name | MyWorkspaceTest |
    Then "MyWorkspaceTest" should be displayed in dashboard workspace


  Scenario: Create a workspace leaving the name field in blank

    When I navigate to dashboard workspace and create a new worksapce as:
      | Name |  |
    Then  Error message should be "Workspace name can't be blank."

  Scenario: Create a workspace with name already exist
    When  I navigate to dashboard workspace and create a new worksapce as:
      | Name | MyWorkspaceTest |
    Then  Error message should be "The workspace name you entered is already taken."
