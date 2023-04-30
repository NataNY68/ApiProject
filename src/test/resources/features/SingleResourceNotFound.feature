@aaa
Feature: Single Resource Not Found

  Scenario: Single Resource Not Found
    Given user send GET request to single resource by providing 'id' and validates status code is 404
    And user validate empty response body with 'id' for single resource
