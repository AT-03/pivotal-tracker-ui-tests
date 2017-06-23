package org.fundacionjala.pivotal.cucumber.selenium.pages;

import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.cucumber.selenium.pages.menu.ToolBars;
import org.fundacionjala.pivotal.cucumber.utils.Environment;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 6/14/2017.
 */
public class SignIn extends AbstractBasePage {
    @FindBy(id = "credentials_username")
    private WebElement emailTextField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTextField;

    @FindBy(name = "action")
    private WebElement nextSignInButton;

    /**
     * Locate element.
     */
    @FindBy(css = ".app_signin_back[href=\"/signin?signin_with_different=true\"]")
    private WebElement signDifferentUser;

    /**
     * Method to perform a login as Primary user.
     *
     * @param userName Username used to perform a login to PivotalTracker application.
     * @param password Password used to perform a login to PivotalTracker application.
     * @return The login to PivotalTracker application.
     */
    public static Dashboard verifyTheLoginOfUser(final String userName,
                                                 final String password) {
        HomePage homePage = new HomePage();
        Dashboard dashboard = new Dashboard();
        try {

            ToolBars toolBars = homePage.goToTopMenu();
            if (!toolBars.isUserLoggedInThePage(toolBars.getUserName())) {
                SignIn signIn = toolBars.logout();
                signIn.clickDifferentUser();
                dashboard = loginAs(userName, password);
            }
        } catch (WebDriverException e) {
            DriverManager.getInstance().getDriver().get(Environment.getInstance().getBaseUrl());
            dashboard = loginAs(userName, password);
        }
        return dashboard;

    }

    /**
     * Method to perform a login as Primary user.
     *
     * @param userName Username used to perform a login to PivotalTracker application.
     * @param password Password used to perform a login to PivotalTracker application.
     * @return The login to PivotalTracker application.
     */
    public static Dashboard loginAs(final String userName, final String password) {

        HomePage homePage = new HomePage();
        SignIn signIn = homePage.clickSigninLink();
        signIn.setEmailTextField(userName);
        signIn.clickNextButton();
        signIn.setPasswordTextField(password);
        return signIn.clickSigninButton();
    }

    /**
     * Method  user for to login.
     *
     * @return Login  application.
     */
    public static Dashboard loginOtherUser() {
        String userNameValue = Environment.getInstance().getUser();
        String passwordValue = Environment.getInstance().getPassword();


        return verifyTheLoginOfUser(Environment.getInstance().getPropertyValue(userNameValue),
                Environment.getInstance().getPropertyValue(passwordValue));
    }

    /**
     * This method set the username in the text field.
     *
     * @param email String whit the email.
     */
    public void setEmailTextField(final String email) {

        CommonActions.setTextField(emailTextField, email);
    }

    /**
     * This method set the password in the text field.
     *
     * @param password String  with the password.
     */
    public void setPasswordTextField(final String password) {
        CommonActions.setTextField(passwordTextField, password);
    }

    /**
     * Method to clickElement on next button.
     */
    public void clickNextButton() {
        CommonActions.clickElement(nextSignInButton);
    }

    /**
     * This method sigin the application.
     *
     * @return Return to home page the PivotalTracker.
     */
    public Dashboard clickSigninButton() {
        CommonActions.clickElement(nextSignInButton);
        return new Dashboard();
    }

    /**
     * click.
     */
    public void clickDifferentUser() {
        CommonActions.clickElement(signDifferentUser);
    }
}
