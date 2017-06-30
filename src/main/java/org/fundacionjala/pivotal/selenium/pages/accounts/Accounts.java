package org.fundacionjala.pivotal.selenium.pages.accounts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;

/**
 * Created by Administrator on 6/12/2017.
 */
public class Accounts extends AbstractBasePage {

    private static final String MANAGE_ACCOUNT = "MANAGE ACCOUNT";

    private static final String ACCOUNT_NOT_FOUND = "Account Not found";

    @FindBy(id = "new_account_link")
    private WebElement createAccountButton;

    @FindBy(css = ".tc-account-selector__create-account-text")
    private WebElement iconButtonAccount;

    @FindBy(css = ".tc-account-creator__name")
    private WebElement inputTextAccount;

    @FindBy(className = "header_button")
    private List<WebElement> manageAccountButtonList;

    @FindBy(css = ".header>h3 .name")
    private List<WebElement> nameAccountList;

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(id = "add_account_button")
    private WebElement addAccountButton;

    /**
     * This method doing click on "Create Account" button.
     */
    private void clickCreateAccountButton() {
        CommonActions.clickElement(createAccountButton);
    }

    /**
     * This method set the account name in the text field.
     *
     * @param accountName String  whit the account name.
     */
    private void setAccountNameTextField(final String accountName) {
        CommonActions.setTextField(accountNameTextField, accountName);
    }

    /**
     * This method added a new account.
     *
     * @return ManageAccount page.
     */
    private ManageAccount clickAddAccountButton() {
        CommonActions.clickElement(addAccountButton);
        return new ManageAccount();
    }

    /**
     * This method deleted all accounts.
     */
    public void deleteAllAccounts() {
        Navigator.goToAccount().getManageAccountButtonList().stream()
                .filter(element -> MANAGE_ACCOUNT.equals(element.getText()))
                .forEach(this::deleteAccount);
    }

    /**
     * This method deleted account.
     *
     * @param webElement WebElement for delete account.
     */
    private void deleteAccount(final WebElement webElement) {
        String attributeValue = webElement.getAttribute("href");
        attributeValue = attributeValue.replace("plans", "settings");
        int indexOf = attributeValue.indexOf("/accounts");
        attributeValue = attributeValue.substring(indexOf);
        ManageAccount manageAccount = clickManageAccount(webElement);
        SettingAccount settingAccount = manageAccount.clickSetting(attributeValue);
        settingAccount.clickDeleteAccountLink();
    }

    /**
     * This method do click on "Manage Account" button.
     *
     * @param manageAccountButton WebElement that represent a "Management Account".
     * @return ManageAccount page.
     */
    private ManageAccount clickManageAccount(final WebElement manageAccountButton) {
        CommonActions.clickElement(manageAccountButton);
        return new ManageAccount();
    }

    /**
     * This method obtains a of WebElement list.
     *
     * @return List the WebElement the button type.
     */
    public List<WebElement> getManageAccountButtonList() {
        return manageAccountButtonList;
    }

    /**
     * This method obtains a of WebElement list.
     *
     * @return List the WebElement the name account type.
     */
    public List<WebElement> getNameAccountList() {
        return nameAccountList;
    }

    /**
     * The method find the name account.
     *
     * @param webElementNameAccount webElement param
     * @param accountName           second param
     * @return String is successful
     */
    public String findAccount(final List<WebElement> webElementNameAccount, final String accountName) {

        for (WebElement webElement : webElementNameAccount) {
            String text = webElement.getText();
            if (accountName.equalsIgnoreCase(text)) {
                return accountName;
            }

        }
        return ACCOUNT_NOT_FOUND;
    }

    /**
     * The method create a new account.
     *
     * @param accountName a new name account
     * @return ManageAccount Instance
     */
    public ManageAccount createAccount(final String accountName) {
        clickCreateAccountButton();
        setAccountNameTextField(accountName);
        return clickAddAccountButton();
    }
}
