package org.fundacionjala.pivotal.hooks.ui;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.selenium.pages.SignIn;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * login hooks.
 */
public class LoginHook {

    /**
     * global hook for login.
     */
    @Before("@login")
    public void loginToPivotal() {

        final String userName = Environment.getInstance().getUser();
        final String password = Environment.getInstance().getPassword();
        SignIn.verifyTheLoginOfUser(Environment.getInstance().getPropertyValue(userName),
                Environment.getInstance().getPropertyValue(password));

    }
}
