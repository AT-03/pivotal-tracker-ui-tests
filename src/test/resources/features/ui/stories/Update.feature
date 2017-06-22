Feature: Update Story

  Background:
    #Given I login to pivotalTracker as "user1"

  Scenario: Verify if the Story can be Update
    #Given Open a project created as "ProjectGUI"
    When I search Story with the name "Gui"
    And I insert the datas for the Story
      | name              | Gui          |
      | Story Type        | Feature      |
      | Points            | 1 Point      |
      | Blockers          | blockersOne  |
      | Label             | Hello        |
    And I click on Close button to update the Story
    Then Verify if the story was Update with the name "UpdateStory"