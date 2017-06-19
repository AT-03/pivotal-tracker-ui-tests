Feature: Story Task Negative

  Background:
    Given I request "POST" "/projects" with:
      | name | ruberproject3 |
    And I stored as [Project1]
    And I request "POST" "/projects/[Project1.id]/stories" with:
      | name | storyRuber1 |
    And I stored as [Story1]

  @deleteProject
  Scenario: Get tasks
    When I request GET "/projects/[Project1.id]/stories/[Story1.id]/tasks"
    Then I expect status code 200
    And the response array should be empty

  @deleteProject
  Scenario: Get Task doesn't exist
    When I request GET "/projects/[Project1.id]/stories/[Story1.id]/tasks/123123"
    Then I expect status code 404
    And the "error" should be "The object you tried to access could not be found.  It may have been removed by another user, you may be using the ID of another object type, or you may be trying to access a sub-resource at the wrong point in a tree."

  @deleteProject
  Scenario: Update task doesn't existe
    When I request "PUT" "/projects/[Project1.id]/stories/[Story1.id]/tasks/123123" with:
      | description | My new Task Edited |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."

  @deleteProject
  Scenario: Delete task doesn't exist
    When I request DELETE "/projects/[Project1.id]/stories/[Story1.id]/tasks/123123"
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."

  @deleteProject
  Scenario: Create task with special characters
    When I request "POST" "/projects/[Project1.id]/stories/[Story1.id]/tasks" with:
      | description | #$%^&&&@*   |
      | complete    | true        |
      | position    | 1           |
    And I stored as [Task1]
    Then I expect status code 200
    And the "description" should be "#$%^&&&@*"

  @deleteProject
  Scenario: Create task with empty description
    When I request "POST" "/projects/[Project1.id]/stories/[Story1.id]/tasks" with:
      | description |             |
      | complete    | true        |
      | position    | 1           |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."

