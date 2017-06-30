package org.fundacionjala.pivotal.stepdefinitions.ui.projects;

import java.util.Map;

import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import org.fundacionjala.pivotal.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectForm;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * Created by Administrator on 6/9/2017.
 */
public class ProjectSteps {

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
        Navigator.goToAccount().createAccount(accountName);
        Navigator.goToDashboard();
    }

}
