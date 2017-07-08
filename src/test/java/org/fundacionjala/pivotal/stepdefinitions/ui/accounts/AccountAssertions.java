package org.fundacionjala.pivotal.stepdefinitions.ui.accounts;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.selenium.pages.accounts.ManageAccount;
import org.fundacionjala.pivotal.selenium.pages.accounts.SettingAccount;


import static org.testng.Assert.assertEquals;

/**
 * Created by reinaldo on 20/06/2017.
 */
public class AccountAssertions {

    /**
     * Constructor where initialize the values.
     */
    public AccountAssertions() {

    }

    /**
     * This is should Be Displayed In Account Details.
     *
     * @param message shouldBeDisplayedInAccountDetails
     */
    @Then("^\"([^\"]*)\" should be displayed in account details$")
    public void shouldBeDisplayedInAccountDetails(final String message) {
        ManageAccount manageAccount = new ManageAccount();
        String messageAccountCreate = manageAccount.getMessageAccountCreate();
        assertEquals(message, messageAccountCreate);
    }

    /**
     * This method should Be Displayed Accounts.
     *
     * @param messageAcccount shouldBeDisplayedAccounts
     */
    @Then("^\"([^\"]*)\" should be displayed accounts$")
    public void shouldBeDisplayedAccounts(final String messageAcccount) {
        ManageAccount manageAccount = new ManageAccount();
        String messageAccountCreate = manageAccount.getMessageAccountUpdate();
        assertEquals(messageAcccount, messageAccountCreate);
    }

    /**
     * This method message Should Be Account.
     *
     * @param messageDelete messageShouldBeAccount
     */
    @Then("^Message should be account \"([^\"]*)\"$")
    public void messageShouldBeAccount(final String messageDelete) {
        new SettingAccount().clickDeleteAccountLink();
        ManageAccount manageAccount = new ManageAccount();
        String messageAccountDelete = manageAccount.getMessageAccountDelete();
        assertEquals(messageDelete, messageAccountDelete);
    }
}

