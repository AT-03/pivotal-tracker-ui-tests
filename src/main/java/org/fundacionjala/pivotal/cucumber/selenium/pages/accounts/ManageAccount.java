package org.fundacionjala.pivotal.cucumber.selenium.pages.accounts;

import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        WebElement settingButton = driver.findElement(By.cssSelector("a[href='" + name + "']"));
        CommonActions.clickElement(settingButton);
        return new SettingAccount();
    }

    /**
     * This method wait while loading element.
     */
    public void waitPage() {
        wait.until(ExpectedConditions.visibilityOf(accountNameLabel));
    }
}
