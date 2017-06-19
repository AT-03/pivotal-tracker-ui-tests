Feature: Story

  Background: At the time to do a GET, PUT or DELETE request, is prerequisite create a new
  story.
    Given I request "POST" "/projects" with:
      | name | project_test |
    And I stored as [ProjectTest]
    And I request "POST" "/projects/[ProjectTest.id]/stories" with:
      | name | my_new_story |
    And I stored as [Story1]

  @deleteProject
  Scenario: Retrieve the story created, after making a correct request.
    When I request GET "/projects/[ProjectTest.id]/stories/[Story1.id]"
    And I expect status code 200
    And the "name" should be "my_new_story"

  @deleteProject
  Scenario: Retrieve the story created, after making an incorrect request.
    When I request GET "/projects/[ProjectTest.id]/stories/noValid"
    And I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."

  @deleteProject
  Scenario: Update the "name" of the story created, after making a correct request.
    When I request "PUT" "/projects/[ProjectTest.id]/stories/[Story1.id]" with:
      | name | my_new_story_updated |
    And I expect status code 200
    And the "name" should be "my_new_story_updated"

  @deleteProject
  Scenario: Update the "estimated" and "current_state" of the story created.
  The "current_state" parameter accepts the next values:
  "accepted", "delivered", "finished", "started", "rejected", "planned",
  "unstarted", "unscheduled". And the "estimate" parameter accepts values from 0 to 3.

    When I request "PUT" "/projects/[ProjectTest.id]/stories/[Story1.id]" with:
      | estimate      | 2        |
      | current_state | accepted |
    And I expect status code 200
    And the "estimate" should be "2"
    And the "current_state" should be "accepted"

  @deleteProject
  Scenario: Delete a story created, after making an correct request.
    When I request DELETE "/projects/[ProjectTest.id]/stories/[Story1.id]"
    And I expect status code 204

  @deleteProject
  Scenario: Delete a story created, after making an incorrect request.
    When I request DELETE "/projects/[ProjectTest.id]/stories/noValid"
    And I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."
