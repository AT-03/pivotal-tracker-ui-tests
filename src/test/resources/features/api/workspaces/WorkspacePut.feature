Feature: WorkspacePut


  Background:
    Given I request "POST" "/my/workspaces" with:
      | name | workspaceTest21 |
    Then I expect status code 200
    And I stored as [Workspace1]
    And I request "POST" "/projects" with:
      | name | projectTest111 |
    Then I expect status code 200
    And I stored as [Project1]
    And I request "POST" "/projects" with:
      | name | projectTest233 |
    Then I expect status code 200
    And I stored as [Project2]

  @deleteProject @deleteWorkspace
  Scenario: PUT workspace with array of project with ids valid
    When I request "PUT" "/my/workspaces/[Workspace1.id]" with:
      | project_ids | [Project1.id],[Project2.id] |
    Then I expect status code 200
