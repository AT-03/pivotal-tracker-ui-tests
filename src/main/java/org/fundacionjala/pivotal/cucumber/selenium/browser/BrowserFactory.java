package org.fundacionjala.pivotal.cucumber.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created on 24/05/2017.
 */
public final class BrowserFactory {
    private static final String BROWSER_NOT_FOUND = "Browser not found.";

    /**
     * constructor.
     */
    private BrowserFactory() {

    }

    /**
     * webDriver function.
     *
     * @param browserName kind of browser.
     * @return the driver
     */
    static WebDriver getDriver(final Browser browserName) {
        switch (browserName) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new WebDriverException(BROWSER_NOT_FOUND);
        }
    }
}

