@aaa
Feature: List of Resources

  Scenario: List of Resources Happy Path
    Given user send GET request to list of resources and validates status code is 200
    And user validates sum of ids equal to 78
    And user validates average years equal to 2005.5

