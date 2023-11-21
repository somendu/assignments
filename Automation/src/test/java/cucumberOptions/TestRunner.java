/**
 * 
 */
package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Test Runner for feature
 * 
 * @author Somendu Maiti
 *
 * @since 21-Nov-2023
 */
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
