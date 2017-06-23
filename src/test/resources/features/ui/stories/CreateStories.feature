Feature: Create Stories

  @goToDashboard @deleteAllProjects
  Scenario: Verify if we can create a new story with the same datas of a story created
    When Open a project created as "ProjectGUI"
    And I insert the datas for the Story
      | NAME        | Gui          |
      | STORY_TYPE  | Feature      |
      | POINTS      | 1 Point      |
      | BLOCKERS    | blockersOne  |
      | DESCRIPTION | RequestSteps |
      | LABEL       | Hello        |
    Then Verify if the story was created with the name "Gui"

  @goToDashboard @deleteAllProjects
  Scenario: Verify if we can create a new story just with the name
    When Open a project created as "ProjectGUI"
    And I insert the datas for the Story
      | NAME | GuiOne |
    Then Verify if the story was created with the name "GuiOne"

  @goToDashboard @deleteAllProjects
  Scenario: Verify if we can create a new story whit same datas
    When Open a project created as "ProjectGUI"
    And I insert the datas for the Story
      | NAME        | StoryNew     |
      | BLOCKERS    | blockersOne  |
      | DESCRIPTION | RequestSteps |
      | LABEL       | Hello        |
    Then Verify if the story was created with the name "StoryNew"

  @goToDashboard @deleteAllProjects
  Scenario: Verify if we can create a new without datas
    When Open a project created as "ProjectGUI"
    And I insert the datas for the Story
      | NAME        |  |
      | STORY_TYPE  |  |
      | POINTS      |  |
      | BLOCKERS    |  |
      | DESCRIPTION |  |
      | LABEL       |  |
    Then Verify if the message should be "Validation Error"