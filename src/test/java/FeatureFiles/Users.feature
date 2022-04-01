Feature: Test users api

  @ValidUserIDs @AllTests
  Scenario Outline: Send Get Requests to users endpoint with valid user ids
    Given Get request sent with valid user id <userID>
    Then The http response code will be <expectedHttpResponse>
    And The first name will be <expectedFirstName>
    And The last name will be <expectedLastName>
    Examples:
      | userID | expectedHttpResponse | expectedFirstName | expectedLastName |
      | 9      | 200                  | Tobias            | Funke            |
      | 12     | 200                  | Rachel            | Howell           |
      | 4      | 200                  | Eve               | Bolt             |

  @InvalidUserID @AllTests
  Scenario Outline: Send Get request with invalid user id
    Given Get request sent with valid user id <userID>
    Then The http response code will be <expectedHttpResponse>
    Examples:
      | userID | expectedHttpResponse |
      | 122    | 404                  |

  @InvalidPageNumber @AllTests
  Scenario Outline: Send Get request with invalid page number
    Given Get request sent with invalid page number <pageNumber>
    Then The http response code will be <expectedHttpResponse>
    And The support message will be <supportMessage>
    Examples:
      | pageNumber | expectedHttpResponse | supportMessage   |
      | 122        | 200                  | To keep ReqRes free, contributions towards server costs are appreciated! |

