package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resource/Feature", // Path to the feature files
    glue = "StepDefinitions", // Path to the step definition classes
    plugin = {
        "pretty",
        "html:target/cucumber.html"// Outputs the results in a readable format
    },
    monochrome = false // Makes the output more readable by removing ANSI colors
)

public class TestRunner {

}
