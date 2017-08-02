package helpers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
     //   format = {"pretty", "json:target/cucumber.json"},
        features = {"src/main/resources"},
        glue = {"helpers", "stepDefinitionFullUrl", "stepDefinitionXmlOrJson", "stepDefinitionUrlWithoutBaseUrl"}
)
public class TestRunner {
}
