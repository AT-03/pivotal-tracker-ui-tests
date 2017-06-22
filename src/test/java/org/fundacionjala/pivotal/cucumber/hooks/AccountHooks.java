package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.commonsteps.CommonStepsUI;

/**
 * Created by Administrator on 20/06/2017.
 */
public class AccountHooks {

    /**
     * Method to delete all Accounts.
     */
    @Before("@deleteAllAccounts")
    public final void deleteAllAccounts() {
        CommonStepsUI.getAccount().deleteAllAccounts(CommonStepsUI.getAccount().getManageAccountButtonList());
        Navigator.goToDashboard();
    }
}
