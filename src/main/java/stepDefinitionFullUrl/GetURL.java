package stepDefinitionFullUrl;

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


public class GetURL {

    Response response;

    @Given("^I will send request to URL in Place$")
    public void sendingGetQuery() throws URISyntaxException{
        URI uri = new URI("https://traffic.cit.api.here.com/traffic/6.2/flow/xml/8/134/86?app_id=99DtaMYpnxA9pNcmsnbj&app_code=F5LQw-YKN02C00SQ3y2TFg");
        response = when().get(uri);
    }

    @Then("^I will check status code equals 200 in Place$")
    public void checkingResponseStatusCode() {
        int code = response.thenReturn().statusCode();
        Assert.assertEquals(HttpStatus.SC_OK, code);
    }

    @And("^I will check response is not empty in Place$")
    public void checkingResponseBody() {
        String bodyResponse = response.body().print();
        boolean b = Pattern.matches(".*CF.*",bodyResponse);
        Assert.assertTrue(b);
    }

}
