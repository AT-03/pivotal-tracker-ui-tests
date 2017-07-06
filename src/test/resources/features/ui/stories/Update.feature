Feature: Update Story

  Background:
    When I request "POST" "/projects" with:
      | name | GUI Project |
    And I stored as [Project1]
    And I request "POST" "/projects/[Project1.id]/stories" with:
      | name | GUI Story |
    And I stored as [Story1]

  @login @goToDashboard @deleteAllProjects
  Scenario: Verify if the Story can be Update
    When Open a project created as "GUI Project"
    And I search Story with the name "GUI Story"
    And I insert the datas for the Story
      | NAME       | GuiUpdate   |
      | STORY_TYPE | Feature     |
      | POINTS     | 1 Point     |
      | BLOCKERS   | blockersOne |
      | LABEL      | Hello       |
    And I click on Close button to update the Story
    Then Verify if the story was created with the name "GuiUpdate"



