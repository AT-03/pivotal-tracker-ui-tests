Feature: Workspace

  Background:
    Given I request "POST" "/my/workspaces" with:
      | name | workspaceTest2 |
    And I stored as [Workspace1]

  @deleteWorkspace
  Scenario: Get Workspace
    When I request GET "/my/workspaces/[Workspace1.id]"
    Then I expect status code 200


  @deleteWorkspace
  Scenario: GET Do not exist project
    When I request GET "/my/workspaces/021512052415420"
    Then I expect status code 404

  @deleteWorkspace
  Scenario: Delete Project if exist.
    When I request DELETE "/my/workspaces/[Workspace1.id]"
    Then I expect status code 204

  @deleteWorkspace
  Scenario: Delete Project if does not exist.
    When I request DELETE "/my/workspaces/121511545121515"
    Then I expect status code 404


  @deleteWorkspace
  Scenario:  workspace PUT with array invalids id projects.
    When I request "PUT" "/my/workspaces/[Workspace.id]" with:
      | project_ids | 21321541545454,12312154512315 |
    Then I expect status code 404









