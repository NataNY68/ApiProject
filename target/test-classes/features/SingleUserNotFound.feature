@aaa
Feature: Single User Not Found

  Scenario: Single User Not Found
    Given user send GET request by providing 'id' and validates status code is 404 for single user
    And user validate empty response body with 'id' for single user
