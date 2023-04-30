@aaa
Feature: Single User


  Scenario Outline: Single User Happy Path
    Given user send GET request to single user and validates status code is 200
    And  And user validates "<id>", "<firstName>", '<lastName>', and '<avatarUrl>' for single user
    And user validate 'https://reqres.in/#support-heading'

    Examples:
      | id | firstName | lastName | avatarUrl                                |
      | 1  | George    | Bluth    | https://reqres.in/img/faces/1-image.jpg  |
      | 2  | Janet     | Weaver   | https://reqres.in/img/faces/2-image.jpg  |
      | 3  | Emma      | Wong     | https://reqres.in/img/faces/3-image.jpg  |
      | 4  | Eve       | Holt     | https://reqres.in/img/faces/4-image.jpg  |
      | 5  | Charles   | Morris   | https://reqres.in/img/faces/5-image.jpg  |
      | 6  | Tracey    | Ramos    | https://reqres.in/img/faces/6-image.jpg  |
      | 7  | Michael   | Lawson   | https://reqres.in/img/faces/7-image.jpg  |
      | 8  | Lindsay   | Ferguson | https://reqres.in/img/faces/8-image.jpg  |
      | 9  | Tobias    | Funke    | https://reqres.in/img/faces/9-image.jpg  |
      | 10 | Byron     | Fields   | https://reqres.in/img/faces/10-image.jpg |
      | 11 | George    | Edwards  | https://reqres.in/img/faces/11-image.jpg |
      | 12 | Rachel    | Howell   | https://reqres.in/img/faces/12-image.jpg |
