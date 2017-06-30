package org.fundacionjala.pivotal.selenium.pages.menu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.SignIn;
import org.fundacionjala.pivotal.selenium.pages.accounts.Accounts;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * Created by Administrator on 6/8/2017.
 */
public class ToolBars extends AbstractBasePage {

    private static final Logger LOGGER = LogManager.getLogger(ToolBars.class);

    private static final int MIN_TIMEOUT = 3;

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
     * Locate element.
     */
    @FindBy(css = "a[href='/accounts']")
    private WebElement accountDropDownItem;

    /**
     * Method to get the user name.
     *
     * @return The user name.
     */
    public String getUserName() {
        String userLogged;
        try {
            driver.manage().timeouts().implicitlyWait(MIN_TIMEOUT, TimeUnit.SECONDS);
            wait.withTimeout(MIN_TIMEOUT, TimeUnit.SECONDS);
            userLogged = this.userMenu.getText();
        } catch (NoSuchElementException e) {
            LOGGER.error("Couldn't find the user name on top menu");
            throw new WebDriverException(e);
        } finally {
            driver.manage().timeouts().implicitlyWait(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
            wait.withTimeout(Environment.getInstance().getTimeout(), TimeUnit.SECONDS);
        }
        return userLogged;
    }


    /**
     * When the user is logged.
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
        CommonActions.clickOnaHiddenElement(userMenu);
    }

    /**
     * Method to perform the logout.
     *
     * @return The login page.
     */
    public SignIn logout() {
        Navigator.goToDashboard();
        clickUserMenu();
        logOutButton.click();
        return new SignIn();
    }

    /**
     * This method do click on "Account" DropDownItem.
     *
     * @return {@link Accounts}
     */
    public Accounts clickAccountDropDownItem() {
        CommonActions.clickElement(accountDropDownItem);
        return new Accounts();
    }

}
