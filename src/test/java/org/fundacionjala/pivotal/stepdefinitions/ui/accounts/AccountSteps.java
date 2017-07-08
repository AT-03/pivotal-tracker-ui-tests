package org.fundacionjala.pivotal.stepdefinitions.ui.accounts;


import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.selenium.pages.accounts.Accounts;
import org.fundacionjala.pivotal.selenium.pages.accounts.ManageAccount;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;

/**
 * Created by Administrator on 6/9/2017.
 */
public class AccountSteps {
    private Accounts accounts;
    private ManageAccount manageAccount;

    /**
     * This method navigate to account.
     */
    @When("^I navigate to accounts$")
    public void iNavigateToAccounts() {
        accounts = Navigator.goToAccount();
    }

    /**
     * This method create a new account.
     *
     * @param accountName account
     */
    @And("^I create a new accounts (.*)$")
    public void iCreateANewAccountsAutomationTestAT(final String accountName) {
        accounts.createAccount(accountName);
    }

    /**
     * This method navigate to settings account.
     */
    @When("^I navigate account Settings$")
    public void iNavigateAccountSettings() {
        manageAccount = new ManageAccount();
        manageAccount.clickSettingAccount();
    }

    /**
     * This method update an account.
     *
     * @param wordChange account
     */
    @And("^I update the next account AutomationTestAT01-03 with \"([^\"]*)\"$")
    public void iUpdateTheNextAccountWith(String wordChange) {
        manageAccount.updateAccountName(wordChange);
        manageAccount.clickButtonSave();
    }
}
