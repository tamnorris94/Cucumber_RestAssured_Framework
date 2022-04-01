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

public class UsersAPI_StepDefs {
    private Response response;
    private ValidatableResponse jsonResp;
    private ValidatableResponse country;

    public UsersAPI_StepDefs(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/users")
                .log(LogDetail.URI)
                .build();
    }

    @Given("^Get request sent with valid user id (.*)$")
    public void i_send_a_get_request_with_valid_location(String userID) {
        response = given().queryParam("page", "2").queryParam("id", userID).when().get();
        System.out.println("Print the response body" +response.body());
    }

    @Given("Get request sent with invalid page number {int}")
    public void get_request_sent_with_invalid_page_number(Integer invalidPageNumber) {
        response = given().queryParam("page", invalidPageNumber).queryParam("id", "1").when().get();
    }

    @Then("^The http response code will be (.*)$")
    public void validate_expected_httpResponseCode(int statusCode) {
        jsonResp = response.then().statusCode(statusCode);
    }

    @Then("^The first name will be (.*)$")
    public void validate_expected_firstName(String expectedFirstName) {
        JsonPath j = new JsonPath(response.asString());
        String firstName = j.getString("data.first_name");
        Assert.assertEquals(firstName, expectedFirstName);
    }

    @Then("^The last name will be (.*)$")
    public void validate_expected_LastName(String expectedLastName) {
        JsonPath j = new JsonPath(response.asString());
        String lastName = j.getString("data.last_name");
        Assert.assertEquals(lastName, expectedLastName);
    }

    @Then("^The support message will be (.*)$")
    public void the_support_message_will_be_support_message(String expectedSupportMessage) {
        JsonPath j = new JsonPath(response.asString());
        String supportMessage = j.getString("support.text");
        Assert.assertEquals(supportMessage, expectedSupportMessage);
    }
}
