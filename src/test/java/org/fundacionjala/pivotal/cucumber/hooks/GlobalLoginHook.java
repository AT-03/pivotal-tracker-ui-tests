package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.cucumber.selenium.pages.SignIn;
import org.fundacionjala.pivotal.cucumber.utils.Environment;

/**
 * login hooks.
 */
public class GlobalLoginHook {

    /**
     * global hook for login.
     */
    @Before
    public void loginToPivotal() {

            final String userName = Environment.getInstance().getUser();
            final String password = Environment.getInstance().getPassword();
            SignIn.verifyTheLoginOfUser(Environment.getInstance().getPropertyValue(userName),
                    Environment.getInstance().getPropertyValue(password));

    }
}
