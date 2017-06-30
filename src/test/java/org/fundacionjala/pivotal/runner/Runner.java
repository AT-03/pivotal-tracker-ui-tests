package org.fundacionjala.pivotal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import org.fundacionjala.pivotal.selenium.browser.DriverManager;

/**
 * Class to execute all feature tests.
 */
@CucumberOptions(
        monochrome = true,
        format = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"
        },
        features = {
                "src/test/resources/features/ui/accounts"
        },
        glue = {
                "org.fundacionjala.pivotal.cucumber"
        }
)
public final class Runner extends AbstractTestNGCucumberTests {

    /**
     * Private constructor.
     */
    private Runner() {
    }

    /**
     * Method to Close the driver after the execution.
     */
    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().getDriver().quit();
    }
}
