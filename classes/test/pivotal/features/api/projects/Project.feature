Feature: Project

  Background:
    Given I request "POST" "/projects" with:
      | name | projectTest58 |
    And I stored as [Project1]

  @deleteProject
  Scenario: Get a Project
    When I request GET "/projects/[Project1.id]"
    Then I expect status code 200

  @deleteProject
  Scenario: Delete a Project
    Then I request DELETE "/projects/[Project1.id]"
    And I expect status code 204

  @deleteProject
  Scenario: Update a Project
    When I request "PUT" "/projects/[Project1.id]" with:
    | name | editedNameTest24 |
    Then I expect status code 200
    And the "name" should be "editedNameTest24"

  @deleteProject
  Scenario: Create an existing project
    When I request "POST" "/projects" with:
      | name | projectTest58 |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."
