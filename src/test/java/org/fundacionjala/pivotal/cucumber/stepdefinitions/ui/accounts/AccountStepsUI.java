package org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.accounts;

import cucumber.api.java.en.When;
import java.util.Map;
import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.cucumber.selenium.pages.accounts.ManageAccount;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navegator;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectForm;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.commonsteps.CommonStepsUI;
import org.fundacionjala.pivotal.cucumber.utils.Environment;

/**
 * Created by Administrator on 6/9/2017.
 */
public class AccountStepsUI {

    private static final Logger LOGGER = Logger.getLogger(Environment.class.getSimpleName());
    private Map<ProjectFormSetting, String> settingMap;

    /**
     * This method deleted all account the project.
     */
    @When("^I delete all account the project$")
    public void deleteAllAccountForProject() {

        CommonStepsUI.getAccount().deleteAllAccounts(CommonStepsUI.getAccount().getManageAccountButtonList());
        Navegator.goToDashboard();
    }

    /**
     * This method added a new project.
     *
     * @param newSettingMap SettingMap that contains the setting for project.
     */
    @When("^I added a new project$")
    public void iAddedANewProject(final Map<ProjectFormSetting, String> newSettingMap) {
        settingMap = newSettingMap;
        Dashboard dashboardPage = new Dashboard();
        ProjectForm projectForm = dashboardPage.clickOnCreateProjectButton();
        projectForm.setConfiguration(newSettingMap);
        projectForm.clickOnCreateAccountButton();
    }

    /**
     * This method obtain settingMap.
     *
     * @return SettingMap to Map type.
     */
    Map<ProjectFormSetting, String> getSettingMap() {
        return settingMap;
    }

    /**
     * This method created a new account.
     *
     * @param accountName String  whit the account name.
     */
    @When("^I create a new account (.*)$")
    public void createANewAccount(final String accountName) {
        ManageAccount manageAccount = CommonStepsUI.getAccount().createAccount(accountName);
        manageAccount.waitPage();
        Navegator.goToDashboard();
    }
}
