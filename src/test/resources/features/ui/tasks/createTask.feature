Feature: Task and Multiple Task

  Background:
    Given I login to pivotal as "user1"
    When I request "POST" "/projects" with:
      | name | GUI Project |
    And I stored as [Project1]
    And I request "POST" "/projects/[Project1.id]/stories" with:
      | name | GUI Story |
    And I stored as [Story1]
    And I go to Dashboard

  @deleteProject
  Scenario: Create a new Task
    Given I open a project with name as "GUI Project"
    And I open a story with name as "GUI Story"
    When I write a or multiple task and press Enter with a following names
      | task1 |
      | task4 |
      | task6 |
      | task2 |
      | task3 |
    Then The task is created correctly
