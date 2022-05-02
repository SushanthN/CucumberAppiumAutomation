package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/proj.json"},
        features = "src/test/java/features",
		glue={"stepdefinitions", "config"}
)


public class Testrunner extends AbstractTestNGCucumberTests {

}
