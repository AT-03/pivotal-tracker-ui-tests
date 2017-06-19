package org.fundacionjala.pivotal.cucumber.selenium.menu;


import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.SignIn;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navegator;
import org.fundacionjala.pivotal.cucumber.utils.Environment;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 6/8/2017.
 */
public class ToolBars extends AbstractBasePage {
    private static final int MIN_TIMEOUT = 3;
    private static final Logger LOGGER = LogManager.getLogger(ToolBars.class);

    /**
     * Locate element.
     */
    @FindBy(css = "[href='/accounts']")
    private WebElement userAccount;

    /**
     * Locate element.
     */
    @FindBy(css = ".tc_dropdown_name")
    private WebElement userMenu;

    /**
     * Locate element.
     */
    @FindBy(css = "._1JRsk__DropdownMenu__menuList>li>form>button")
    private WebElement logOutButton;

    /**
     * Locate element.
     */
    @FindBy(id = "ProjectsPaneUpdated OpenCreateProjectModal-button")
    private WebElement createProyectButton;

    /**
     * Locate element.
     */
    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement toggleBar;

    /**
     * Method to get the user name.
     *
     * @return The user name.
     */
    public String getUserName() {
        String userLogged = "";

        try {
            getWebDriver().manage().timeouts().implicitlyWait(MIN_TIMEOUT, TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(MIN_TIMEOUT, TimeUnit.SECONDS);
            userLogged = this.userMenu.getText();
        } catch (NoSuchElementException e) {
            LOGGER.error("Couldn't find the user name on top menu");
            throw new WebDriverException(e);
        } finally {
            getWebDriver().manage().timeouts().implicitlyWait(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
        }
        return userLogged;
    }

    /**
     * Whent the user is logged.
     *
     * @param account The user account.
     * @return The user account.
     */
    public boolean isUserLoggedInThePage(final String account) {
        return getUserName().equalsIgnoreCase(account);
    }

    /**
     * This method clicks the user menu.
     */
    public void clickUserMenu() {
        try {
            DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(userMenu));
            CommonActions.clickOnaHiddenElement(userMenu);
        } catch (WebDriverException e) {
            LOGGER.warn("The userMenu is delaying to much in loading");
            clickUserMenu();
        }
    }

    /**
     * Method to perform the logout.
     *
     * @return The login page.
     */
    public SignIn logout() {
        Navegator.goToDashBoard();
        this.clickUserMenu();
        logOutButton.click();
        return new SignIn();
    }

}
