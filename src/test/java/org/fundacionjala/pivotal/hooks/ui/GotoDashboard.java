package org.fundacionjala.pivotal.hooks.ui;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;

/**
 * Created by Administrator on 6/23/2017.
 */
public class GotoDashboard {

    /**
     * Hook for go to dashboard.
     */
    @Before("@goToDashboard")
    public void goToDashboard() {
        Navigator.goToDashboard();
    }
}
