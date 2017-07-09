Feature: project delete archive and unarchive

  Background:
    Given I request "POST" "/projects" with:
  | name | project255511234564 |
    And I stored as [project1]

  @gotodasboard @login
  Scenario: Delete a project
    When I delete "project1"
    Then Message should be "project123456 was successfully deleted."

  @deleteProject @goToDashboard @login
  Scenario: update name of project
    When I update "project1" with "project2":
    Then Message should be "Changes saved."

  @deleteProject @goToDashboard @login
  Scenario: Archive project
    When I "Active Projects" the "project1"
    Then Message should be "Project archived"

