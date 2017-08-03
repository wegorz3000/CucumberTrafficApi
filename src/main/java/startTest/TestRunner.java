package startTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
     //   format = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/java/resources/features"},
        //glue = {"CommonSteps", "src/test/java/steps/v1/common"}
        glue = {"src/test/java/steps/v1/common"}

)
public class TestRunner {
}
