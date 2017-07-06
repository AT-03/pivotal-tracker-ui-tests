Feature: Account

  Scenario: Retrieve all the user's accounts after performed a correct
  GET request.
    When I request GET "/accounts"
    Then I expect status code 200
    And The response array should not be empty

  Scenario: Try to retrieve all the user's accounts after performed a incorrect
  GET request.
    When I request GET "/Accounts"
    Then I expect status code 404
    And the "error" should be "The path you requested has no valid endpoint."
