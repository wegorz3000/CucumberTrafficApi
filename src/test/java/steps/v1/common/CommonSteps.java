package steps.v1.common;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.testng.Assert;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static com.jayway.restassured.RestAssured.given;

public class CommonSteps extends BaseClass {

    //    String str = System.getProperty("PROPERTIES_PATH");
//    try{
//        Properties props = new Properties(str);
//    } catch(FileNotFoundException e){
//        LOG.error('file wa snot foound');
//        throw new FrameworkExceptions(ExceptionType.CONFIG_ERROR, e.getMessage());
//    }
    RestAssured restAssured = new RestAssured();
    public StringBuilder requestBuilder = new StringBuilder("");

    public Response response;
    HashMap<String, String> headers = new HashMap<>();

    @Given("^I will set request body from template$")
    public void i_will_set_body_request_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        restAssured.baseURI = baseUrl; //normal will be taken from properties
        restAssured.basePath = path;

        requestBuilder.append(type + returnType);
        requestBuilder.append(z + "/" + x + "/" + y);
    }

    @And("^I set query parameter is \"([^\"]*)\" and have value \"([^\"]*)\"$")
    public void i_set_query_parameter(String queryParameterName, String queryParameterValue) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requestBuilder.append("?" + queryParameterName + "=" + queryParameterValue);
    }


    @When("^I set query parameters:$")
    public void i_set_query_parameters(Map<String, String> queryParametersMap) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requestBuilder.append("?");
        StringJoiner stringJoiner = new StringJoiner("&");
        for (String keyParameter : queryParametersMap.keySet()) {
            stringJoiner.add(keyParameter + "=" + queryParametersMap.get(keyParameter));
            requestBuilder.append(keyParameter + "=" + queryParametersMap.get(keyParameter) + "&");
        }
    }

    @And("^I will add request headers:$")
    public void i_will_add_request_headers(Map<String, String> headersMap) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        given().headers(headersMap);
    }

    @And("^I will set \"([^\"]*)\" request$")
    public void i_will_set_request_URL(String expectedRequestType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RequestType parsRequestType = RequestType.valueOf(expectedRequestType);

        switch (parsRequestType) {
            case GET:
                response = given().log().all().get(requestBuilder.toString());
                break;
            case POST:
                response = RestAssured.post(requestBuilder.toString());
                break;
            default:
                throw new PendingException();
        }
    }

    @When("^I will set \"([^\"]*)\" request with \"([^\"]*)\"$")
    public void i_will_set_request_with(String expectedRequestType, String urlAddress) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RequestType parsRequestType = RequestType.valueOf(expectedRequestType);
        switch (parsRequestType) {
            case GET:
                response = restAssured.given().log().all().get(urlAddress);
                break;
            case POST:
                response = restAssured.given().post(urlAddress);
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
        String responseBody = String.valueOf(response.body());
        Assert.assertTrue(responseBody.contains(word));
    }

    @Then("^I will validate body not contains \"([^\"]*)\"$")
    public void i_will_validate_body_not_contains(String word) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String bodyResponse = String.valueOf(response.body());
        response.print();
        Assert.assertFalse(bodyResponse.contains(word));
    }

    @Then("^I will validate response header contains \"([^\"]*)\"$")
    public void i_will_validate_response_header_contains(String responseHeader) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String headerResponse = response.getHeaders().toString();
        Assert.assertTrue(headerResponse.contains(responseHeader));
    }

    @Then("^Body contains xPath \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void body_contains_xPath_with_value(String xPathExpression, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(requestBuilder.toString());

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(xPathExpression);
        Assert.assertEquals(arg2,expr);
        expr.evaluate(doc, XPathConstants.STRING);
    }

    public enum RequestType {
        GET,
        POST;
    }
}