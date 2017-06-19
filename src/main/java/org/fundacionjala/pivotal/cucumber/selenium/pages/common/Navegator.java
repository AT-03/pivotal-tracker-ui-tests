package org.fundacionjala.pivotal.cucumber.selenium.pages.common;

import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;

/**
 * Created by Administrator on 6/2/2017.
 */
public final class Navegator {
    /**
     * constructor.
     */
    private Navegator() {
    }

    /**
     * nav.
     */
    public static void goToDashBoard() {
        DriverManager.getInstance().getDriver()
                .get("https://www.pivotaltracker.com/dashboard");
    }
}
