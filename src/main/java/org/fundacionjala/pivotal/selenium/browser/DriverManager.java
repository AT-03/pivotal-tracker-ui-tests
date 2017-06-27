package org.fundacionjala.pivotal.selenium.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.pivotal.utils.Environment;

/**
 *
 */
public final class DriverManager {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * Constructor.
     */
    private DriverManager() {
        final int timeOut = ENVIRONMENT.getTimeout();
        final Browser browser = Browser.valueOf(ENVIRONMENT.getBrowser().toUpperCase());
        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        driver.get(ENVIRONMENT.getBaseUrl());
        wait = new WebDriverWait(driver, timeOut);
    }

    /**
     * getInstance.
     *
     * @return the instance
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Gets Driver instance.
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets wait instance.
     *
     * @return the wait.
     */
    public WebDriverWait getWait() {
        return wait;
    }

}
