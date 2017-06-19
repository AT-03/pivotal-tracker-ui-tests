Feature: Stories.

  Background: To create a new story or to retrieve all stories created, it is necessary
  to have a "project_id", so this background has the task of creating a new project.
    Given I request "POST" "/projects" with:
      | name | project_test |
    And I stored as [Project1]

  @deleteProject
  Scenario: Create a new story using only the parameter: "name".
    When I request "POST" "/projects/[Project1.id]/stories" with:
      | name | my_new_story |
    Then I expect status code 200
    And the "name" should be "my_new_story"

  @deleteProject
  Scenario: Create a new story using the parameters "name", "story_type", "estimate"
  "description", "current_state", "created_at".
  The parameter "story_type" is capable of receive three enumerated strings: feature, bug, chore
  and release.
  The parameter "estimate" is capable of receive the following values: 0, 1, 2 and 3.
  The parameter "description" is capable of receive an extended_string value.
  The parameter "current_state" is capable of receive the following values:
  "accepted", "delivered", "finished", "started", "rejected", "planned",
  "unstarted", "unscheduled"
  The parameters "created_at" and "accepted_at" are capable of receive
  a "datetime" value. e.g. 2017-06-09T12:00:00Z or 1367296015000(milliseconds)
    When I request "POST" "/projects/[Project1.id]/stories" with:
      | name          | my_new_story               |
      | estimate      | 2                          |
      | story_type    | feature                    |
      | description   | This is a description test |
      | current_state | accepted                   |
      | created_at    | 2017-06-09T10:00:00Z       |
      | accepted_at   | 2017-06-09T12:00:00Z       |

    Then I expect status code 200
    And the "name" should be "my_new_story"
    And the "story_type" should be "feature"
    And the "estimate" should be "2"
    And the "description" should be "This is a description test"
    And the "current_state" should be "accepted"
    And the "created_at" should be "2017-06-09T10:00:00Z"
    And the "accepted_at" should be "2017-06-09T12:00:00Z"

  @deleteProject
  Scenario: The response array after GET all stories from a project recently created
  should be empty.
    When I request GET "/projects/[Project1.id]/stories"
    Then I expect status code 200
    And the response array should be empty
