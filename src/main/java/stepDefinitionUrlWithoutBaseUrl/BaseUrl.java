package stepDefinitionUrlWithoutBaseUrl;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

import static com.jayway.restassured.RestAssured.when;

public class BaseUrl {
    Response response;

    @Given("^I will send request to URL in base$")
    public void sendingAnotherGetQuery() throws URISyntaxException {
        String baseUrl = "https://traffic.cit.api.here.com";
        String page = baseUrl + "/traffic/6.2/flow/xml/16/19295/24640?app_id=99DtaMYpnxA9pNcmsnbj&app_code=F5LQw-YKN02C00SQ3y2TFg";
        URI uri = new URI(page);
        response = when().get(uri);
    }

    @Then("^I will check status code equals 200 in base$")
    public void checkingAnotherResponseStatusCode() {
        int code = response.thenReturn().statusCode();
        Assert.assertEquals(HttpStatus.SC_OK, code);
    }


    @And("^I will check response is not empty in base$")
    public void checkingAnotherResponseBody() {
        String bodyResponse = response.body().print();
        boolean b = Pattern.matches(".*RW.*",bodyResponse);
        Assert.assertTrue(b);
    }
}
