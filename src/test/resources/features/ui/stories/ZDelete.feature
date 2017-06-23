Feature: Delete Story

  @goToDashboard @deleteAllProjects
  Scenario: Verify if we can delete a Story created
    When Open a project created as "ProjectGUI"
    And I search a Story with the name "GuiUpdate" to delete it
    And I delete a story
    Then The message should be "1 story deleted"