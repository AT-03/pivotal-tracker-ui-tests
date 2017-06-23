Feature: Update Story

  Scenario: Verify if the Story can be Update
    When I search Story with the name "Gui"
    And I insert the datas for the Story
      | name       | Gui         |
      | Story Type | Feature     |
      | Points     | 1 Point     |
      | Blockers   | blockersOne |
      | Label      | Hello       |
    And I click on Close button to update the Story

  Scenario: Verify if the Story can be Update just with the name
    When I search Story with the name "StoryONe"
    And I insert the datas for the Story
      | name | Gui |
    And I click on Close button to update the Story

  Scenario: Verify if the Story can be Update with same datas
    When I search Story with the name "StoryNew"
    And I insert the datas for the Story
      | name     | Gui         |
      | Blockers | blockersOne |
      | Label    | Hello       |
    And I click on Close button to update the Story

  Scenario: Verify if the Story can be Update without datas
    When I search Story with the name "Gui"
    And I insert the datas for the Story
      | name       |  |
      | Story Type |  |
      | Points     |  |
      | Blockers   |  |
      | Label      |  |
    And I click on Close button to update the Story