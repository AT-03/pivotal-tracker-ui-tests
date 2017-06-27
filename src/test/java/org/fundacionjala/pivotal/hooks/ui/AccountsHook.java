package org.fundacionjala.pivotal.hooks.ui;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;

/**
 * Created by Administrator on 20/06/2017.
*/
public class AccountsHook {

    /**
     * Method to delete all Accounts.
     */
    @Before("@deleteAllAccounts")
    public final void deleteAllAccounts() {
        CommonActions.getAccount().deleteAllAccounts(CommonActions.getAccount().getManageAccountButtonList());
        Navigator.goToDashboard();
    }

}
