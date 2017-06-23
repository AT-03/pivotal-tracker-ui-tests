Feature: Create Stories

  @deleteProject
  Scenario: Verify if we can create a new story with the same datas of a story created
    When I click on the button Add Story
    And I insert the datas for the Story
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
    When I click on the button Add Story
    And I insert the datas for the Story
      | name | StoryONe |
    And I save the Story
    Then Verify if the story was created with the name "StoryONe"

  @deleteProject
  Scenario: Verify if we can create a new story whit same datas
    When I click on the button Add Story
    And I insert the datas for the Story
      | name        | StoryNew     |
      | Blockers    | blockersOne  |
      | Description | RequestSteps |
      | Label       | Hello        |
    And I save the Story
    Then Verify if the story was created with the name "StoryNew"

  @deleteProject
  Scenario: Verify if we can create a new without datas
    When I click on the button Add Story
    And I insert the datas for the Story
      | name        |  |
      | Story Type  |  |
      | Points      |  |
      | Blockers    |  |
      | Description |  |
      | Label       |  |
    And I save the Story
    Then Verify if the message show it should be "Validation Error"