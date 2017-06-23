package org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.accounts;

import java.util.Map;

import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import org.fundacionjala.pivotal.cucumber.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.cucumber.selenium.pages.accounts.ManageAccount;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectForm;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.cucumber.utils.Environment;

/**
 * Created by Administrator on 6/9/2017.
 */
public class AccountStepsUI {

    private static final Logger LOGGER = Logger.getLogger(Environment.class.getSimpleName());
    private Map<ProjectFormSetting, String> settingMap;

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
        projectForm.setConfiguration(settingMap);
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
     * @param accountName String  with the account name.
     */
    @When("^I create a new account (.*)$")
    public void createANewAccount(final String accountName) {
        ManageAccount manageAccount = CommonActions.getAccount().createAccount(accountName);
        manageAccount.waitPage();
        Navigator.goToDashboard();
    }

}
