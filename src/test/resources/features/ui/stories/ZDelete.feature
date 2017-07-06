Feature: Delete Story

  Background:
    When I request "POST" "/projects" with:
      | name | GUI Project |
    And I stored as [Project1]
    And I request "POST" "/projects/[Project1.id]/stories" with:
      | name | GUI Story |
    And I stored as [Story1]

  @login @goToDashboard @deleteAllProjects
  Scenario: Verify if we can delete a Story created
    When Open a project created as "GUI Project"
    And I search a Story with the name "GUI Story" to delete it
    And I delete a story
    Then The message should be "1 story deleted"