package org.fundacionjala.pivotal.stepdefinitions.ui.projects;

import java.util.Map;

import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import org.fundacionjala.pivotal.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectForm;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectSettings;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * Created by Administrator on 6/9/2017.
 */
public class ProjectSteps {

    private static final Logger LOGGER = Logger.getLogger(Environment.class.getSimpleName());
    private Map<ProjectFormSetting, String> settingMap;

    private Dashboard initDastBoard;
    private ProjectSettings projectSettings;

    /**
     * @param dashBoard       in the constructor StepDefinition.
     * @param projectSettings in the constructor StepDefinition.
     */
    public ProjectSteps(final Dashboard dashBoard,
                        final ProjectSettings projectSettings) {

        this.initDastBoard = dashBoard;
        this.projectSettings = projectSettings;
    }

    /**
     * This method added a new project.
     *
     * @param newSettingMap SettingMap that contains the setting for project.
     */
    @When("^I added a new project$")
    public void iAddedANewProject(final Map<ProjectFormSetting, String> newSettingMap) {
        Navigator.goToDashboard();
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

    /**
     * @param name for the after delete en UI form.
     */
    @When("^I delete \"([^\"]*)\"$")
    public void iDelete(final String name) {
        Navigator.goToDashboard();
        initDastBoard.searchForAProject(name);
        initDastBoard.clickOnProjectSettingButton();
        projectSettings.clickOnDeleteLink();
        projectSettings.clickOnConfirmDeleteButton();
    }

    /**
     * @param name1 atribute for the change.
     * @param name2 atribute for update a name1.
     */
    @When("^I update \"([^\"]*)\" with \"([^\"]*)\":$")
    public void iUpdateWith(final String name1, final String name2) {
        Navigator.goToDashboard();
        initDastBoard.searchForAProject(name1);
        initDastBoard.clickOnProjectSettingButton();
        projectSettings.updateProjectName(name2);
        projectSettings.setProjectDescription(name2);
        projectSettings.clickOnSaveProjectButton();
        Navigator.goToDashboard();
    }

    /**
     * @param action is the method two differents actions
     * @param name   atribute do action sending.
     */
    @When("^I \"([^\"]*)\" the \"([^\"]*)\"$")
    public void iThe(final String action, final String name) {
        Navigator.goToDashboard();
        initDastBoard.searchForAProject(name);
        initDastBoard.clickOnProjectSettingButton();
        projectSettings.clickOnArchive();
        projectSettings.clickOnConfirmArchive();

    }

    /**
     * @return projectSettings atribute.
     */
    ProjectSettings getProjectSettings() {
        return projectSettings;
    }

    /**
     * @return initDastBoard atribute.
     */
    Dashboard getDastBoard() {
        return initDastBoard;
    }


}
