Feature: Update and delete task

  Background:
    When I request "POST" "/projects" with:
      | name | GUI Project |
    And I stored as [Project1]
    And I request "POST" "/projects/[Project1.id]/stories" with:
      | name | GUI Story |
    And I stored as [Story1]
    And I request "POST" "/projects/[Project1.id]/stories/[Story1.id]/tasks" with:
      | description | GUI Task |
    And I stored as [Task1]

  @login @goToDashboard @deleteAllProjects
  Scenario: Update a task
    Given I open a project with name as "GUI Project"
    And I open a story with name as "GUI Story"
    And I update the next task "GUI Task" with "GUI Update"
    Then I close the story

  @goToDashboard @deleteAllProjects
  Scenario: Delete a task
    Given I open a project with name as "GUI Project"
    And I open a story with name as "GUI Story"
    And I delete the next task "GUI Task"
    Then I close the story
