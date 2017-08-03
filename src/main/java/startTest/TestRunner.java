package startTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
     //   format = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/java/resources/features"},
        glue = {"startTest", "src/test/java/tests/steps/flow/entireUrl"}
)
public class TestRunner {
}
