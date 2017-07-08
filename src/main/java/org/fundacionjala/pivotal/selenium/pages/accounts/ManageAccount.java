package org.fundacionjala.pivotal.selenium.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;

/**
 * This class doing the manage the accounts.
 */
public class ManageAccount extends AbstractBasePage {

    @FindBy(className = "account_name")
    private WebElement accountNameLabel;

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(xpath = "//a[contains(.,'Settings')]")
    private WebElement buttonSetting;

    @FindBy(id = "notice")
    private WebElement messageUpdateAccount;

    @FindBy(css = ".header_button")
    private WebElement buttonSave;


    /**
     * This method doing click on "Setting" button.
     *
     * @param name String  whit the setting name.
     * @return SettingAccount page.
     */
    SettingAccount clickSetting(final String name) {
        wait.until(ExpectedConditions.visibilityOf(accountNameLabel));
        final String selector = "a[href='%s']";
        WebElement settingButton = driver.findElement(By.cssSelector(String.format(selector, name)));
        CommonActions.clickElement(settingButton);
        return new SettingAccount();
    }

    /**
     * This method return the message for create.
     *
     * @return String message create
     */
    public String getMessageAccountCreate() {
        return accountNameLabel.getText();
    }

    /**
     * This method  update the name.
     *
     * @param accountName update
     */
    public void updateAccountName(final String accountName) {
        CommonActions.setTextField(accountNameTextField, accountName);
    }

    /**
     * Click deploy button setting.
     *
     * @return ManageAccount object
     */

    public ManageAccount clickSettingAccount() {
        CommonActions.clickElement(buttonSetting);
        return this;
    }

    /**
     * This method return the message update.
     *
     * @return String getMessageAccount.
     */
    public String getMessageAccountUpdate() {
        return messageUpdateAccount.getText();
    }

    /**
     * This method save the new data.
     */
    public void clickButtonSave() {
        CommonActions.clickElement(buttonSave);
    }

    /**
     * This would notice the message.
     *
     * @return String messageDelete
     */
    public String getMessageAccountDelete() {
        return messageUpdateAccount.getText();
    }
}
