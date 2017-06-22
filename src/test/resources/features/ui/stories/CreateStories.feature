Feature: Create Stories

  Background:
    #Given I login to pivotalTracker as "user1"

  @deleteProject
  Scenario: Verify if we can create a new story with the same datas of a story created
    #Given Open a project created as "ProjectGUI"
    When I click on the button Add Story
    And I insert datas for the Story
      | name        | Gui          |
      | Story Type  | Feature      |
      | Points      | 1 Point      |
      | Blockers    | blockersOne  |
      | Description | RequestSteps |
      | Label       | Hello        |
    And I save the Story
    Then Verify if the story was created with the name "Gui"

  @deleteProject
  Scenario: Verify if we can create a new story just with the name
    #Given Open a project created as "ProjectGUI"
    When I click on the button Add Story
    And I insert datas for the Story
      | name | Gui |
    And I save the Story
    Then Verify if the story was created with the name "Gui"

  @deleteProject
  Scenario: Verify if we can create a new story just with the name
    #Given Open a project created as "ProjectGUI"
    When I click on the button Add Story
    And I insert datas for the Story
      | name | Gui |
    And I save the Story
    Then Verify if the story was created with the name "Gui"

  @deleteProject
  Scenario: Verify if we can create a new story with same datas only
    #Given Open a project created as "ProjectGUI"
    When I click on the button Add Story
    And I insert datas for the Story
      | name        | Gui          |
      | Blockers    | blockersOne  |
      | Description | RequestSteps |
      | Label       | Hello        |
    And I save the Story
    Then Verify if the story was created with the name "Gui"

  @deleteProject
  Scenario: Verify if we can create a new story with empty datas
    #Given Open a project created as "ProjectGUI"
    When I click on the button Add Story
    And I insert datas for the Story
      | name        |  |
      | Story Type  |  |
      | Points      |  |
      | Blockers    |  |
      | Description |  |
      | Label       |  |
    And I save the Story
    Then Verify the message should be "Validation Error"