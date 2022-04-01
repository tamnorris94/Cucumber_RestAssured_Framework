Feature: Test users api

  @ValidUserIDs @AllTests
  Scenario Outline: Send Get Requests to users endpoint with valid user ids
    Given Get request sent with valid user id <userID>
    Then The http response code will be <expectedHttpResponse>
    And The first name will be <expectedFirstName>
    And The last name will be <expectedLastName>
  Examples:
    |userID|expectedHttpResponse|expectedFirstName|expectedLastName|
    |9     |200                 |Tobias           |Funke           |
    |12     |200                 |Rachel           |Howell           |
    |4     |200                 |Eve           |Bolt           |

  @InvalidUserID @AllTests
  Scenario Outline: Send Get request with invalid user id
    Given Get request sent with valid user id <userID>
    Then The http response code will be <expectedHttpResponse>
  Examples:
    |userID|expectedHttpResponse|
    |122   |404                 |

