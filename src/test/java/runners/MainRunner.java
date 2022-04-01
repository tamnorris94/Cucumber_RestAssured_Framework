package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(//features= {"classpath:FeatureFiles/CompareNumbers.feature"},
                 features = {"src/test/java/FeatureFiles"},
                 glue= {"StepDefs"},
                 tags= "@AllTests",
                 plugin = {"pretty","html:target/cucumber-report.html"
                 },
                 monochrome = false, dryRun = false)
public class MainRunner extends AbstractTestNGCucumberTests {

}
