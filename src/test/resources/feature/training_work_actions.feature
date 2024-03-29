Feature: Training Work Actions Handling

  Scenario: Successfully adding a training action
    Given I have a training request with "add" action
    When I send the training request to the actionTraining endpoint
    Then I should receive a "200 OK" status
    And the response should contain "add Action Completed successfully"

  Scenario: Successfully deleting a training action
    Given I have a training request with "delete" action
    When I send the training request to the actionTraining endpoint
    Then I should receive a "200 OK" status
    And the response should contain "delete Action Completed successfully"

  Scenario: Sending a training request with an unsupported action
    Given I have a training request with "update" action
    When I send the training request to the actionTraining endpoint
    Then I should receive a "400 Bad Request" status
    And the error response should detail a "MissingAttributes" issue with a message "Action must be add or delete"

  Scenario: Sending a training request without an action
    Given I have a training request without an action
    When I send the training request to the actionTraining endpoint
    Then I should receive a "400 Bad Request" status
    And the error response should detail a "MissingAttributes" issue with a message "Action is required"

  Scenario: Attempting to delete a training action for a non-existent entity
    Given I have a training request with "delete" action for a non-existent user
    When I send the training request to the actionTraining endpoint
    Then I should receive a "404 Not Found" status
    And the error response should detail a "NotFoundException" issue