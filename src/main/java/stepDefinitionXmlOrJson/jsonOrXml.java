package stepDefinitionXmlOrJson;

import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.net.URI;
import java.util.regex.Pattern;

import static com.jayway.restassured.RestAssured.when;

public class jsonOrXml {
    Response response;

    @Given("^I will send \"([^\"]*)\" request to URL$")
    public void sendRequestToUrl(String returnType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String page = "https://traffic.cit.api.here.com/traffic/6.2/flow/"+returnType+"/16/19295/24640?app_id=99DtaMYpnxA9pNcmsnbj&app_code=F5LQw-YKN02C00SQ3y2TFg";
        URI uri = new URI(page);
        response = when().get(uri);
        throw new PendingException();
    }

    @Then("^I will check status code equals (\\d+)$")
    public void checkingStatusCode(int statusCode) throws Throwable {
        int code = response.thenReturn().statusCode();
        Assert.assertEquals(statusCode, code);
        throw new PendingException();
    }

    @And("^I will check response has xml response$")
    public void checkingXmlResponse() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String bodyResponse = response.body().print();
        boolean b = Pattern.matches(".*><RW.*",bodyResponse);
        Assert.assertTrue(b);
        throw new PendingException();
    }

    @And("^I will check response is not empty$")
    public void checkingResponseIsNotEmpty() throws Throwable {
        String bodyResponse = response.body().print();
        boolean b = Pattern.matches(".*RW.*",bodyResponse);
        Assert.assertTrue(b);
        throw new PendingException();
    }

    @And("^I will check response has json response$")
    public void checkingJsonResponse() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String bodyResponse = response.body().print();
        boolean b = Pattern.matches(".*\"RW\": .*",bodyResponse);
        Assert.assertTrue(b);
        throw new PendingException();
    }

}
