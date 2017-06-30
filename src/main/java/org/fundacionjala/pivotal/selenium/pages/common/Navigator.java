package org.fundacionjala.pivotal.selenium.pages.common;

import org.fundacionjala.pivotal.selenium.browser.DriverManager;
import org.fundacionjala.pivotal.selenium.pages.accounts.Accounts;
import org.fundacionjala.pivotal.selenium.pages.menu.ToolBars;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * Created by Administrator on 6/2/2017.
 */
public final class Navigator {
    private static final String DASHBOARD = "dashboard";

    /**
     * Constructor private.
     */
    private Navigator() {
    }

    /**
     * This method go to dashboard page.
     */
    public static void goToDashboard() {
        final String url = String.format("%s/%s", Environment.getInstance().getBaseUrl(), DASHBOARD);
        DriverManager.getInstance().getDriver().navigate().to(url);
    }

    /**
     * This method return an account.
     *
     * @return Account return an account
     */
    public static Accounts goToAccount() {
        ToolBars topMenu = new ToolBars();
        topMenu.clickUserMenu();
        return topMenu.clickAccountDropDownItem();
    }
}
