Feature: Delete Story

  Scenario: Verify if we can delete a Story created
    When I search a Story with the name "UpdateStory" to delete it
    And I click on checkBox of the Story created
    And I click on the button Delete
    Then I click on confirm button to delete the story
    Then The message should be "1 story deleted"