Feature: Training Work Actions Handling

  Scenario: Successfully adding a training action
    Given I have a training request with "add" action
    When I send the training request to the actionTraining endpoint
    Then I should receive a 200 status code

  Scenario: Successfully deleting a training action
    Given I have a training request with "delete" action
    When I send the training request to the actionTraining endpoint
    Then I should receive a 200 status code

  Scenario: Sending a training request with an unsupported action
    Given I have a training request with "update" action
    When I send the training request to the actionTraining endpoint
    Then I should receive a 400 status code

  Scenario: Sending a training request without an action
    Given I have a training request without an action
    When I send the training request to the actionTraining endpoint
    Then I should receive a 400 status code

  Scenario: Attempting to delete a training action for a non-existent entity
    Given I have a training request with "delete" action for a non-existent user
    When I send the training request to the actionTraining endpoint
    Then I should receive a 404 status code