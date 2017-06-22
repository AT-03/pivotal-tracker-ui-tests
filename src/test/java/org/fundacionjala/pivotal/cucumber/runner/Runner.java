package org.fundacionjala.pivotal.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.testng.annotations.AfterClass;

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
        },
        tags = { "~@loginAt03"}
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
