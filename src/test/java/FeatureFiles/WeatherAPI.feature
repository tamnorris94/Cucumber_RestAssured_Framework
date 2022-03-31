Feature: Test a REST API GET method
  \

  @locationsTest @allTests
  Scenario Outline: Send GET request to weather api endpoint
    Given Get request sent with valid location <location>
    Then The http response code will be <expectedHttpResponse>
    And The country will be <expectedCountry>
    And The weather conditions will be <expectedConditions>
    Examples:
      | location     | expectedHttpResponse | expectedCountry |expectedConditions|
      | London       | 200                  | United Kingdom  |Clear             |
      | New Plymouth | 200                  | New Zealand     |Raining           |

  @invalidClientKey @allTests
  Scenario Outline: Send GET weather request with invalid client key
    Given I send a request with an invalid client key
    Then The http response code will be <expectedHttpResponse>
    Examples:
      | expectedHttpResponse |
      | 401                  |