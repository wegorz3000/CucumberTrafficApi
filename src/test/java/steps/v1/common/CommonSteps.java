package steps.v1.common;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.regex.Pattern;

public class CommonSteps extends BaseClass {

//    String str = System.getProperty("PROPERTIES_PATH");
//    try{
//        Properties props = new Properties(str);
//    } catch(FileNotFoundException e){
//        LOG.error('file wa snot foound');
//        throw new FrameworkExceptions(ExceptionType.CONFIG_ERROR, e.getMessage());
//    }

    StringBuilder requestBuilder = new StringBuilder("");

    public Response response;
    RequestType requestType;
    HashMap<String, Header> headers = new HashMap<String, Header>();


    @Given("^I will set request body from template$")
    public void i_will_set_body_request_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   RestAssured.baseURI = baseUrl; //normal will be taken from properties
       // RestAssured.basePath = path;

        requestBuilder.append(baseUrl+path+type+returnType);
        requestBuilder.append(z+"/"+x+"/"+y);
        throw new PendingException();
    }

    @And("^I will set \"([^\"]*)\" request URL$")
    public void i_will_set_request_URL(String requestType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (requestType == RequestType.GET.toString()) {
            response = RestAssured.get(requestBuilder.toString());
        } else if (requestType == RequestType.POST.toString()) {
            response = RestAssured.post(requestBuilder.toString());
        } else {
            throw new PendingException();
        }
    }

    @Given("^I will add request headers$")
    public void i_will_add_request_headers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I set query parameter is \"([^\"]*)\" and have value \"([^\"]*)\"$")
    public void i_set_query_parameter(String a1, String a2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        throw new PendingException();
    }

    @When("^I set query parameters$")
    public void i_set_query_parameters() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I will validate status code is \"([^\"]*)\"$")
    public void i_will_validate_status_code_is(String statusCode) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(!(String.valueOf(response.getStatusCode())==statusCode))
            throw new PendingException();
    }

    @Then("^I will validate status message is \"([^\"]*)\"$")
    public void i_will_validate_status_message(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(!response.getStatusLine().contains(message))
            throw new PendingException();
    }

    @Then("^I will validate body contains \"([^\"]*)\"$")
    public void i_will_validate_body_contains(String word) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String responseBody = response.body().print();
        if(!responseBody.contains(word))
            throw new PendingException();
    }

    @Then("^I will validate body not contains$")
    public void i_will_validate_body_not_contains() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String bodyResponse = response.body().print();
        if(!bodyResponse.isEmpty())
            throw new PendingException();
    }

    @Then("^I will validate response header contains \"([^\"]*)\"$")
    public void i_will_validate_response_header_contains(String responseHeader) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String headerResponse = response.getHeaders().toString();
        if (!headerResponse.contains(responseHeader))
            throw new PendingException();
    }
    /*
    set request URL
    set request body from template
    add request header
    set/add query parameter
    set/add query parameters
    send "type" request with url
    send "type" request
    validate status code
    validate status message (okay forbidden)
    validate body contains
    validate body not contains
    validate response header

     */


    public enum RequestType {
        GET,
        POST;
    }
}
