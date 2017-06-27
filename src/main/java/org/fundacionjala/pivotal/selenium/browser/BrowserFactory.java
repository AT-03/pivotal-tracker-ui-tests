package org.fundacionjala.pivotal.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Browser Factory.
 */
public final class BrowserFactory {

    private static final String BROWSER_NOT_FOUND = "Browser not found.";

    /**
     * constructor.
     */
    private BrowserFactory() {
    }

    /**
     * driver function.
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
