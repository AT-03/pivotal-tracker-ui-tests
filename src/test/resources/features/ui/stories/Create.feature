Feature: Create Story

  Background:
    Given I login to pivotalTracker as "user1"
    When  I request "POST" "/projects" with:
      | name | ProjectGUI |
    And I stored as [ProjectGUI]
    And I go to DashBoard
    Then Open a project created as "ProjectGUI"

  @deleteProject
  Scenario: Verify if a Story can be create
    When I click on the button Add Story
    And I insert datas for the Story
      | name              | Gui          |
      | Story Type        | Feature      |
      | Points            | 1 Point      |
      | Blockers          | blockersOne  |
      | DescriptionUpDate | RequestSteps |
      | Label             | Hello        |
    And I save the Story
    Then Verify if the story was created with the name "Gui"











