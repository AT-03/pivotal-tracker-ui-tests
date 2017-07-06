Feature: Create Story

  Background:
    When I request "POST" "/projects" with:
      | name | GUI Project |
    And I stored as [Project1]

  @login @goToDashboard @deleteProject
  Scenario: Verify if a Story can be create
    When Open a project created as "GUI Project"
    And I insert the datas for the Story
      | NAME        | Gui          |
      | STORY_TYPE  | Feature      |
      | POINTS      | 1 Point      |
      | BLOCKERS    | blockersOne  |
      | DESCRIPTION | RequestSteps |
      | LABEL       | Hello        |
    Then Verify if the story was created with the name "Gui"











