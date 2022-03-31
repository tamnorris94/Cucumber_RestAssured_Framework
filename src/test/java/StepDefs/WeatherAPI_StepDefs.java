package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class WeatherAPI_StepDefs {

    private Response response;
    private ValidatableResponse jsonResp;
    private ValidatableResponse country;

    public WeatherAPI_StepDefs(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.weatherapi.com/v1/current.json?key=2cdb15a0d4f6460d9e7193709223003&q=London&aqi=no")
                .log(LogDetail.URI)
                .build();
    }

    @Given("^Get request sent with valid location (.*)$")
    public void i_send_a_get_request_with_valid_location(String location) {
        response = given().queryParam("q", location).queryParam("key", "2cdb15a0d4f6460d9e7193709223003").when().get();
        //System.out.println("Print the response body" +response.body());
    }

    @Given("^I send a request with an invalid client key$")
    public void i_send_a_get_request_with_invalid_key() {
        response = given().queryParam("q", "London").queryParam("key", "2cdb15a0d4f6460d9e7193709223004").when().get();
        //System.out.println("Print the response body" +response.jsonPath().getString("location"));
    }

    @Then("^The http response code will be (.*)$")
    public void validate_expected_httpResponseCode(int statusCode) {
        jsonResp = response.then().statusCode(statusCode);
    }

    @Then("^The country will be (.*)$")
    public void validate_expected_country(String expectedCountry) {
        JsonPath j = new JsonPath(response.asString());
        String country = j.getString("location.country");
        System.out.println("Country is: " + country);
        Assert.assertEquals(country, expectedCountry);
    }

    @Then("^The weather conditions will be (.*)$")
    public void validate_expected_conditions(String expectedCondition) {
        JsonPath j = new JsonPath(response.asString());
        String conditions = j.getString("current.condition.text");
        Assert.assertEquals(conditions, expectedCondition);
    }


}
