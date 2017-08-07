package steps.v1.common;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

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
    HashMap<String, String> headers = new HashMap<>();

    @Given("^I will set request body from template$")
    public void i_will_set_body_request_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
           RestAssured.baseURI = baseUrl; //normal will be taken from properties
           RestAssured.basePath = path;

        requestBuilder.append(type + returnType);
        requestBuilder.append(z + "/" + x + "/" + y);
    }


//    @And("^I set query parameter is \"([^\"]*)\" and have value \"([^\"]*)\"$")
//    public void i_set_query_parameter(String queryParameterName, String queryParameterValue) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        requestBuilder.append("?" + queryParameterName + "=" + queryParameterValue);
//    }

    @And("^I set query parameter is \"([^\"]*)\" and have value \"([^\"]*)\"$")
    public void i_set_query_parameter(String queryParameterName, String queryParameterValue) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requestBuilder.append("?"+queryParameterName+"="+queryParameterValue+"&app_code=F5LQw-YKN02C00SQ3y2TFg");
// TODO - zle napisane
    }


    @When("^I set query parameters: (.*)$")
    public void i_set_query_parameters(List<String> queryParameterList) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requestBuilder.append("?");
        for (String parameter : queryParameterList) {
            requestBuilder.append(parameter + "&");
        }
        //TODO w tablicy?

    }

    @And("^I will add request headers$")
    public void i_will_add_request_headers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.given().headers(headers);
        //TODO - headers - Where are their place? in properties or not?
    }


    @And("^I will set \"([^\"]*)\" request URL$")
    public void i_will_set_request_URL(String expectedRequestType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RequestType parsRequestType = RequestType.valueOf(expectedRequestType);
        switch (parsRequestType) {
            case GET:
                response = RestAssured.get(requestBuilder.toString());
                break;
            case POST:
                response = RestAssured.post(requestBuilder.toString());
                break;
            default:
                throw new PendingException();
        }
    }

    @Then("^I will validate status code is \"([^\"]*)\"$")
    public void i_will_validate_status_code_is(String statusCode) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int stCode = response.getStatusCode();
        int stIntCode = Integer.parseInt(statusCode);
        Assert.assertEquals(stCode, stIntCode);
    }

    @Then("^I will validate status message is \"([^\"]*)\"$")
    public void i_will_validate_status_message(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(response.getStatusLine().contains(message));
    }

    @Then("^I will validate body contains \"([^\"]*)\"$")
    public void i_will_validate_body_contains(String word) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String responseBody = response.body().print();
        Assert.assertTrue(responseBody.contains(word));
        throw new PendingException();
    }

    @Then("^I will validate body not contains \"([^\"]*)\"$")
    public void i_will_validate_body_not_contains(String word) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String bodyResponse = response.body().print();
        Assert.assertFalse(bodyResponse.contains(word));
    }

    @Then("^I will validate response header contains \"([^\"]*)\"$")
    public void i_will_validate_response_header_contains(String responseHeader) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String headerResponse = response.getHeaders().toString();
        Assert.assertTrue(headerResponse.contains(responseHeader));
    }

    public enum RequestType {
        GET,
        POST;
    }
}
