package org.fundacionjala.pivotal.cucumber.selenium.pages.accounts;

import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class doing the manage the setting the account.
 */
public class SettingAccount extends AbstractBasePage {
    @FindBy(css = "a.button.current")
    private WebElement settingButton;
    @FindBy(css = "div.description > a")
    private WebElement deleteAccountLink;

    /**
     * This method doing click on "Ok alert Message" button.
     */
    private void clickOKAlertMessage() {
        getWebDriver().switchTo().alert().accept();
    }

    /**
     * This method doing click on "Delete Account" link.
     */
    void clickDeleteAccountLink() {
        CommonActions.clickElement(deleteAccountLink);
        clickOKAlertMessage();
    }
}
