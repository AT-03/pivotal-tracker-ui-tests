Feature: Update Story

  @goToDashboard @deleteAllProjects
  Scenario: Verify if the Story can be Update
    When Open a project created as "ProjectGUI"
    And I search Story with the name "Gui"
    And I insert the datas for the Story
      | NAME       | GuiUpdate   |
      | STORY_TYPE | Feature     |
      | POINTS     | 1 Point     |
      | BLOCKERS   | blockersOne |
      | LABEL      | Hello       |
    And I click on Close button to update the Story
    Then Verify if the story was created with the name "GuiUpdate"

  @goToDashboard @deleteAllProjects
  Scenario: Verify if the Story can be Update just with the name
    When Open a project created as "ProjectGUI"
    And I search Story with the name "StoryONe"
    And I insert the datas for the Story
      | NAME | StoryOneUpdate |
    And I click on Close button to update the Story
    Then Verify if the story was created with the name "StoryOneUpdate"

  @goToDashboard @deleteAllProjects
  Scenario: Verify if the Story can be Update with same datas
    When Open a project created as "ProjectGUI"
    And I search Story with the name "StoryNew"
    And I insert the datas for the Story
      | NAME     | StoryNewUpdate |
      | BLOCKERS | blockersOne    |
      | LABEL    | Hello          |
    And I click on Close button to update the Story
    Then Verify if the story was created with the name "StoryNewUpdate"

  @goToDashboard @deleteAllProjects
  Scenario: Verify if the Story can be Update without datas
    When Open a project created as "ProjectGUI"
    And I search Story with the name "Gui"
    And I insert the datas for the Story
      | NAME       |  |
      | STORY_TYPE |  |
      | POINTS     |  |
      | BLOCKERS   |  |
      | LABEL      |  |
    And I click on Close button to update the Story