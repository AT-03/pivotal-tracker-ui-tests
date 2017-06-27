package org.fundacionjala.pivotal.selenium.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;

/**
 * This class doing the manage the accounts.
 */
public class ManageAccount extends AbstractBasePage {

    @FindBy(className = "account_name")
    private WebElement accountNameLabel;

    /**
     * This method doing click on "Setting" button.
     *
     * @param name String  whit the setting name.
     * @return SettingAccount page.
     */
    SettingAccount clickSetting(final String name) {
        wait.until(ExpectedConditions.visibilityOf(accountNameLabel));
        final String selector = "a[href='%s']";
        WebElement settingButton = driver.findElement(By.cssSelector(String.format(selector, name)));
        CommonActions.clickElement(settingButton);
        return new SettingAccount();
    }

}
