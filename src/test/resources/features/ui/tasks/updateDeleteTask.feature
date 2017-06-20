Feature: Update and delete task

  Background:
    Given I login to pivotal as "user1"
    When I request "POST" "/projects" with:
      | name | GUI Project |
    And I stored as [Project1]
    And I request "POST" "/projects/[Project1.id]/stories" with:
      | name | GUI Story |
    And I stored as [Story1]
    And I request "POST" "/projects/[Project1.id]/stories/[Story1.id]/tasks" with:
      | description | GUI Task |
    And I stored as [Task1]
    And I go to Dashboard

  @deleteAllProjects
  Scenario: Update a task
    Given I open a project with name as "GUI Project"
    And I open a story with name as "GUI Story"
    And I update the next task "GUI Task" with "GUI Update"
    Then The task is update correctly

  @deleteAllProjects
  Scenario: Delete a task
    Given I open a project with name as "GUI Project"
    And I open a story with name as "GUI Story"
    And I delete the next task "GUI Task"
    Then The task is delete correctly
