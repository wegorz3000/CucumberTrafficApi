package StartTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty"},
        features = {"src/test/java/resources/features"},
      //  glue = {"CommonSteps", "src/test/java/steps/v1/common"}

        glue = {"steps.v1.common"}

)
public class TestRunner {
}
