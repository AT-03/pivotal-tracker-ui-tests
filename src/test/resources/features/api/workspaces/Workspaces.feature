Feature: Workspaces empty

  Scenario: GET an empty workspace
    When I request GET "/my/workspaces"
    Then I expect status code 200


  @deleteWorkspace
  Scenario: Create  workspace

    When I request "POST" "/my/workspaces" with:
      | name | workspaceTest5 |
    Then I expect status code 200
    And I stored as [Workspace1]
    And the "name" should be "workspaceTest5"


  Scenario: do not Create workspace with same name.
    When I request "POST" "/my/workspaces" with:
      | name | workspace |
    When I request "POST" "/my/workspaces" with:
      | name | workspace |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."


  Scenario: Post do not Create workspace with name in blank.
    When I request "POST" "/my/workspaces" with:
      | name |  |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."







