package org.fundacionjala.pivotal.hooks.ui;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.selenium.pages.SignIn;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * login hooks.
 */
public class UIHook {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    /**
     * global hook for login.
     */
    @Before("@login")
    public void loginToPivotal() {
        SignIn.loginOtherUser(ENVIRONMENT.getUser(), ENVIRONMENT.getPassword());
    }

    /**
     * Hook for go to dashboard.
     */
    @Before("@goToDashboard")
    public void goToDashboard() {
        Navigator.goToDashboard();
    }


    /**
     * Method to delete all Accounts.
     */
    @Before("@deleteAllAccounts")
    public final void deleteAllAccounts() {
        Navigator.goToAccount().deleteAllAccounts();
    }

}
