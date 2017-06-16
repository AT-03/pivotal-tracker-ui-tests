Feature: Story Task

  Background:
    Given I request "POST" "/projects" with:
      | name | testtest22 |
    And I stored as [Project1]
    And I request "POST" "/projects/[Project1.id]/stories" with:
      | name | storyRuber1 |
    And I stored as [Story1]
    And I request "POST" "/projects/[Project1.id]/stories/[Story1.id]/tasks" with:
      | description | My new Task |
      | complete    | true        |
      | position    | 1           |
    And I stored as [Task1]

  @deleteProject
  Scenario: Create Task
    Then I expect status code 200
    And the "description" should be "My new Task"

  @deleteProject
  Scenario: Get Task
    When I request GET "/projects/[Project1.id]/stories/[Story1.id]/tasks/[Task1.id]"
    Then I expect status code 200

  @deleteProject
  Scenario: Update Task
    When I request "PUT" "/projects/[Project1.id]/stories/[Story1.id]/tasks/[Task1.id]" with:
      | description | My new Task Edited |
    Then I expect status code 200
    And the "description" should be "My new Task Edited"

    @deleteProject
  Scenario: Delete task
    When I request DELETE "/projects/[Project1.id]/stories/[Story1.id]/tasks/[Task1.id]"
    Then I expect status code 204

    @deleteProject
    Scenario: Create task with existing description
      When I request "POST" "/projects/[Project1.id]/stories/[Story1.id]/tasks" with:
        | description | My new Task |
        | complete    | true        |
        | position    | 1           |
      Then I expect status code 200
      And the "description" should be "My new Task"

