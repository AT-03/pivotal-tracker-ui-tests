package org.fundacionjala.pivotal.cucumber.selenium.browser;

import java.util.concurrent.TimeUnit;

import org.fundacionjala.pivotal.cucumber.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 5/29/2017.
 */
public final class DriverManager {
    /**
     * instance.
     */
    private static final Environment ENVIRONMENT = Environment.getInstance();
    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor.
     */
    private DriverManager() {
        final int timeOut = ENVIRONMENT.getTimeout();
        final String baseUrl = ENVIRONMENT.getBaseUrl();
        final Browser browser = Browser.valueOf(ENVIRONMENT.getBrowser().toUpperCase());
        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        driver.get(baseUrl);
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
     * getDriver.
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * getwait.
     *
     * @return the wait.
     */
    public WebDriverWait getWait() {
        return wait;
    }


}
