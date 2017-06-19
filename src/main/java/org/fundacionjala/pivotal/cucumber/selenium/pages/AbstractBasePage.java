package org.fundacionjala.pivotal.cucumber.selenium.pages;


import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * This base page abstract class.
 */
public abstract class AbstractBasePage {

    private WebDriver webDriver;

    /**
     * HomePage constructor.
     */
    public AbstractBasePage() {
        this.setWebDriver(DriverManager.getInstance().getDriver());
        PageFactory.initElements(getWebDriver(), this);
    }

    /**
     * The method webdriver().
     *
     * @return driver data.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * This is setWebDriver.
     *
     * @param webDriver data
     */
    public void setWebDriver(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
