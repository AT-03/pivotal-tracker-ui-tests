package org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.accounts;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.Map;

import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectForm;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectManagement;

import static org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting.ACCOUNT;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.junit.Assert.assertEquals;

/**
 * Created by reinaldo on 20/06/2017.
 */
public class AccountAssertionUI {

    private Map<ProjectFormSetting, String> settingMap;

    /**
     * Constructor where initialize the values.
     *
     * @param accountStepsUI ResourcesStep.
     */
    public AccountAssertionUI(final AccountStepsUI accountStepsUI) {

        settingMap = accountStepsUI.getSettingMap();
    }

    /**
     * this method verify that a new project is created.
     */
    @Then("Verify that a new project is created")
    public void verifyThatANewProjectIsCreated() {
        ProjectManagement projectManagement = new ProjectManagement();
        final String expected = projectManagement.getProjectName();
        final String actual = settingMap.get(PROJECT_NAME);
        assertEquals(expected, actual);
    }

    /**
     * The method verify a account with his account.
     */
    @And("^Verify the new account with his project$")
    public void verifyTheNewAccountWithHisProject() {
        Navigator.goToDashboard();
        final String itemAccount = settingMap.get(ACCOUNT);
        String resultActual = CommonActions.getAccount().
                findAccount(CommonActions.getAccount().getNameAccountList(), itemAccount);
        Navigator.goToDashboard();
        assertEquals(itemAccount, resultActual);

    }

    /**
     * this is the method error message account.
     *
     * @param messageProject require field
     * @param messageAccount require field
     */
    @Then("^The project should to message as \"([^\"]*)\" and the account \"([^\"]*)\"$")
    public void theProjectShouldToMessageAsAndTheAccount(final String messageProject, final String messageAccount) {
        ProjectForm projectForm = new ProjectForm();
        String messageErrorProject = projectForm.getMessageErrorProject();
        String messageErrorAccount = projectForm.getMessageErrorAccount();
        Navigator.goToDashboard();
        assertEquals(messageProject, messageErrorProject);
        assertEquals(messageAccount, messageErrorAccount);
    }

    /**
     * The method require the fill the field.
     *
     * @param messageProject require the fill the field
     */
    @Then("^The project should to message as \"([^\"]*)\"$")
    public void theProjectShouldToMessageAs(final String messageProject) {
        ProjectForm projectForm = new ProjectForm();
        String messageErrorProject = projectForm.getMessageErrorProject();
        Navigator.goToDashboard();
        assertEquals(messageProject, messageErrorProject);
    }
}
