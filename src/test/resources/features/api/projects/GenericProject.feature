Feature: GenericProject

  @deleteProject
  Scenario: Create Project
    When I request "POST" "/projects" with:
      | name | Rubertest12 |
    Then I expect status code 200
    And I stored as [Project1]
    And the "name" should be "Rubertest12"

  Scenario: list projects
    When I request GET "/projects"
    Then I expect status code 200

  Scenario: Get project doesn't exist
      When I request GET "/projects/1231231"
      Then I expect status code 404
      And the "error" should be "The object you tried to access could not be found.  It may have been removed by another user, you may be using the ID of another object type, or you may be trying to access a sub-resource at the wrong point in a tree."

  Scenario: Update project doesn't exist
    When I request "PUT" "/projects/123123123" with:
      | name | projectTest123412312 |
    Then I expect status code 404
    And the "error" should be "The object you tried to access could not be found.  It may have been removed by another user, you may be using the ID of another object type, or you may be trying to access a sub-resource at the wrong point in a tree."

  Scenario: Create Project with empty name
    When I request "POST" "/projects" with:
      | name | |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."

    @deleteProject
  Scenario: Create Project with special characters
    When I request "POST" "/projects" with:
      | name | %^&*()%$^$(&@&( |
    And I stored as [Project2]
    Then I expect status code 200
    And the "name" should be "%^&*()%$^$(&@&("


  @deleteProject
  Scenario: Create Project with more than 50 chars
    When I request "POST" "/projects" with:
      | name | 123456789012345678901234567890123456789012345678901 |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."

  @deleteProject
  Scenario: Create Project already exists
    Given I request "POST" "/projects" with:
      | name | projectTest41 |
    And I stored as [Project1]
    When I request "POST" "/projects" with:
      | name | projectTest41 |
    Then I expect status code 400
    And the "error" should be "One or more request parameters was missing or invalid."
