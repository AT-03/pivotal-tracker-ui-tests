Feature: WorkspacesArray

  Background:
    Given I request "POST" "/projects" with:
      | name | projectTest1 |
    And I stored as [Project1]
    And I request "POST" "/projects" with:
      | name | projectTest2 |
    And I stored as [Project2]

  @deleteProject @deleteWorkspace
  Scenario: The workspace should not be created with invalid  projects ids.

    When I request "POST" "/my/workspaces" with:
      | name        | Workspacesfull              |
      | project_ids | 1545212154545,1527451543545 |

    Then I expect status code 400

  @deleteProject @deleteWorkspace
  Scenario: The workspace should not be created with same name.

    When I request "POST" "/my/workspaces" with:
      | name        | Workspacesfull              |
    And I stored as [Workspace1]
    And I request "POST" "/my/workspaces" with:
      | name        | Workspacesfull              |
      | project_ids | Project1.id,Project2.id |

    Then I expect status code 400

  @deleteProject @deleteWorkspace
  Scenario:  Workspace PUT with array invalids workspace.
    When I request "PUT" "/my/workspaces/1214545145215454" with:
      | project_ids | project1.id,project2.id |
    Then I expect status code 400

  @deleteProject @deleteWorkspace
  Scenario: Create a workspace with array of project.

    When I request "POST" "/my/workspaces" with:
      | name        | Workspaces123          |
      | project_ids |[Project1.id],[Project2.id] |
    Then I expect status code 200
    And I stored as [Workspace1]
