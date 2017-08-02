/*
package stepDefinitionXYZ;

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

public class xyzParameters {
    Response response;
    int x, y, z;

    @Given("^I will create request with xyz parameters$")
    public void sendingAnotherGetQuery() throws URISyntaxException {
        String page = "https://traffic.cit.api.here.com/traffic/6.2/flow/xml/16/19295/24640?app_id=99DtaMYpnxA9pNcmsnbj&app_code=F5LQw-YKN02C00SQ3y2TFg";
        URI uri = new URI(page);
        response = when().get(uri);
    }

    @Then("^I submit the valid data$")
    public void checkingAnotherResponseStatusCode() {
        int code = response.thenReturn().statusCode();
        Assert.assertEquals(HttpStatus.SC_OK, code);
    }


    @And("^I will check status code equals$")
    public void checkingAnotherResponseBody() {
        String bodyResponse = response.body().print();
        boolean b = Pattern.matches(".*RW.*",bodyResponse);
        Assert.assertTrue(b);
    }

}
*/