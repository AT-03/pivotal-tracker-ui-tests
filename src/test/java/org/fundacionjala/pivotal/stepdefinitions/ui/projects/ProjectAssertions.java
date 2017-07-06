package org.fundacionjala.pivotal.stepdefinitions.ui.projects;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.fundacionjala.pivotal.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectForm;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.selenium.pages.project.ProjectManagement;

import static org.fundacionjala.pivotal.selenium.pages.project.ProjectFormSetting.ACCOUNT;
import static org.fundacionjala.pivotal.selenium.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.junit.Assert.assertEquals;

/**
 * Created by reinaldo on 20/06/2017.
 */
public class ProjectAssertions {

    private Map<ProjectFormSetting, String> settingMap;

    private ProjectSteps projectSteps1;
    /**
     * Constructor where initialize the values.
     *
     * @param projectSteps ResourcesStep.
     */
    public ProjectAssertions(final ProjectSteps projectSteps) {

        this.projectSteps1 = projectSteps;
        settingMap = projectSteps.getSettingMap();
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
        String resultActual = Navigator.goToAccount().
                findAccount(Navigator.goToAccount().getNameAccountList(), itemAccount);
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



    /**
     * @param message verify the message is correct.
     */
    @Then("^Message should be \"([^\"]*)\"$")
    public void messageShouldBe(final String message) {
        if ("project1 was successfully deleted.".equals(message)) {
            assertEquals(projectSteps1.getDastBoard().verifyDeletionMessage(), message);
        }
        if ("Changes saved".equals(message)) {
            assertEquals(projectSteps1.getProjectSettings().verifyUpdate(), message);
        }
        if ("Project Unarchived".equals(message)) {
            assertEquals(projectSteps1.getProjectSettings().verifyUnarchive(), message);
        }
        if ("Project Archived".equals(message)) {
            assertEquals(projectSteps1.getDastBoard().verifyArchive(), message);
        }
}

}
