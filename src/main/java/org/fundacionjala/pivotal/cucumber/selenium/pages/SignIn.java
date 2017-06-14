package org.fundacionjala.pivotal.cucumber.selenium.pages;

import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 6/14/2017.
 */
public class SignIn {
  @FindBy(id = "credentials_username")
  private WebElement emailTextField;

  @FindBy(id = "credentials_password")
  private WebElement passwordTextField;

  @FindBy(name = "action")
  private WebElement nextSigninButton;

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
   * @param password String  whit the password.
   */
  public void setPasswordTextField(final String password) {
    CommonActions.setTextField(passwordTextField, password);
  }

  /**
   * Method to clickElement on next button.
   */
  public void clickNextButton() {
    CommonActions.clickElement(nextSigninButton);
  }

  /**
   * This method sigin the application.
   *
   * @return Return to home page the PivotalTracker.
   */
  public Dashboard clickSigninButton() {
    CommonActions.clickElement(nextSigninButton);
    return new Dashboard();
  }

  /**
   * Method to perform a login as Primary user.
   *
   * @param userName Username used to perform a login to Mach2 application.
   * @param password Password used to perform a login to Mach2 application.
   * @return The login to Mach2 application.
   */
  public static Dashboard loginAs(final String userName, final String password) {
    HomePage homePage = new HomePage();
    SignIn signIn = homePage.clickSigninLink();
    signIn.setEmailTextField(userName);
    signIn.clickNextButton();
    signIn.setPasswordTextField(password);
    return signIn.clickSigninButton();
  }
}
