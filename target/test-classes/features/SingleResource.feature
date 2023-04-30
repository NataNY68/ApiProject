@aaa
Feature: Single Resource


  Scenario Outline: Single Resource Happy Path
    Given user send GET request to single resource and validates status code is 200
    And   user validates "<id>", "<year>", '<color>', for single resource
   And user validates 'To keep ReqRes free, contributions towards server costs are appreciated!' for each single user with '<id>'

    Examples:
      | id | year | color   |
      | 1  | 2000 | #98B2D1 |
      | 2  | 2001 | #C74375 |
      | 3  | 2002 | #BF1932 |
      | 4  | 2003 | #7BC4C4 |
      | 5  | 2004 | #E2583E |
      | 6  | 2005 | #53B0AE |
      | 7  | 2006 | #DECDBE |
      | 8  | 2007 | #9B1B30 |
      | 9  | 2008 | #5A5B9F |
      | 10 | 2009 | #F0C05A |
      | 11 | 2010 | #45B5AA |
      | 12 | 2011 | #D94F70 |
