package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetRequestStepDefinition {
    private RequestSpecification request;
    private Response response;

    @Given("^I have acces to perform GET request$")
    public void iHaveAccesToPerformGETRequest() throws Throwable {
      request = given().
              baseUri("http://bhdtest.endava.com:8080/petclinic/api").
              contentType(ContentType.JSON);
    }

    @When("^I perform GET request to \"([^\"]*)\"$")
    public void iPerformGETRequestTo(String path) throws Throwable {
       response = request.when().get(path);
    }

    @Then("^I will have status code \"([^\"]*)\"$")
    public void iWillHaveStatusCode(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());
    }

    @Given("^I have acces to perform POST request$")
    public void iHaveAccesToPerformPOSTRequest() throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                body("{\"name\": \"Liliac\"}").
                contentType(ContentType.JSON);
    }

    @When("^I perform a POST request to \"([^\"]*)\"$")
    public void iPerformAPOSTRequestTo(String path) throws Throwable {
        response = request.when().post(path);
    }

    @Given("^I have acces to perform PUT request$")
    public void iHaveAccesToPerformPUTRequest() throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                //body("{\"name\": \"liliac\"}").
                pathParam("petTypeId", 10).
                contentType(ContentType.JSON);

    }

    @When("^I perform a PUT request to \"([^\"]*)\"$")
    public void iPerformAPUTRequestTo(String path) throws Throwable {
       response = request.when().put(path);
    }

    @Given("^I have acces to perform DELETE request$")
    public void iHaveAccesToPerformDELETERequest() throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                //body("{\"name\": \"liliac\"}").
                pathParam("petTypeId", 185).
                contentType(ContentType.JSON);
    }

    @When("^I perform a DELETE request to \"([^\"]*)\"$")
    public void iPerformADELETERequestTo(String path) throws Throwable {
            response = request.when().delete(path);
    }
}
