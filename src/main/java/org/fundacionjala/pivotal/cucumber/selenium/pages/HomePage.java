package org.fundacionjala.pivotal.cucumber.selenium.pages;

import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.cucumber.selenium.pages.menu.ToolBars;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 6/14/2017.
 */
public class HomePage extends AbstractBasePage {
    @FindBy(css = "div.header__lg > a[href='/signin']")
    private WebElement signinLink;

    /**
     * This method to clicks on the "Signin" link on the home page.
     *
     * @return Return to SignIn page.
     */
    public SignIn clickSigninLink() {
        CommonActions.clickElement(signinLink);
        return new SignIn();
    }

    /**
     * Method of menu.
     *
     * @return The Top menu.
     */
    public ToolBars goToTopMenu() {

        return new ToolBars();
    }
}
