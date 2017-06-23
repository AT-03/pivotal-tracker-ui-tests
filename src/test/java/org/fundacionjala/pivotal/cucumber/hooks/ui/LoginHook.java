package org.fundacionjala.pivotal.cucumber.hooks.ui;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.cucumber.selenium.pages.SignIn;
import org.fundacionjala.pivotal.cucumber.utils.Environment;

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
