package org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.commonsteps;

import org.fundacionjala.pivotal.cucumber.selenium.pages.accounts.Accounts;
import org.fundacionjala.pivotal.cucumber.selenium.pages.menu.ToolBars;

/**
 * Created by Administrator on 6/13/2017.
 */
public final class CommonStepsUI {

    /**
     * The constructor.
     */
    private CommonStepsUI() {

    }

    /**
     * This method return an account.
     *
     * @return Account return an account
     */
    public static Accounts getAccount() {
        ToolBars topMenu = new ToolBars();
        topMenu.clickUserMenu();
        Accounts account = topMenu.clickAccountDropDownItem();
        return account;
    }
}
