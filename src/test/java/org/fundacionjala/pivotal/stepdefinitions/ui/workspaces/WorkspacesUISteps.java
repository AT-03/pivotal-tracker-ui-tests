package org.fundacionjala.pivotal.stepdefinitions.ui.workspaces;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.selenium.pages.workspaces.WorkSpacesSettings;
import org.fundacionjala.pivotal.selenium.pages.workspaces.WorkspaceMain;

import org.fundacionjala.pivotal.selenium.pages.workspaces.Workspaces;

import org.testng.Assert;

import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Administrator on 6/20/2017.
 */
public class WorkspacesUISteps {


    private Dashboard dashBoard;
    private Workspaces workSpaces;
    private WorkSpacesSettings workSpacesSettings;


    /**
     * Constructor.
     *
     * @param dashboard          class
     * @param workspaces         class
     * @param workSpacesSettings class
     * @param workspaceMain      class
     */

    public WorkspacesUISteps(final Dashboard dashboard, final Workspaces workspaces, final WorkSpacesSettings
            workSpacesSettings, final WorkspaceMain workspaceMain) {
        this.dashBoard = dashboard;
        this.workSpaces = workspaces;
        this.workSpacesSettings = workSpacesSettings;

    }


    /**
     * Method.
     *
     * @param workspaceName the name.
     */
    @Then("^\"([^\"]*)\" should be displayed in dashboard workspace$")
    public void shouldBeDisplayedInDashboardWorkspace(final String workspaceName) {
        Navigator.goToDashboard();
        Navigator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
        workSpaces.selectAworkSpace(workspaceName);
        Navigator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
        Assert.assertTrue(workSpaces.verifyIfAworkSpaceExist(workspaceName));

    }

    /**
     * METHOD.
     *
     * @param workspaceName the name
     * @param newName       the nnew name.
     */
    @When("^I navigate dashboard workspace and update the \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iNavigateDashboardWorkspaceAndUpdateTheWith(final String workspaceName, final String newName) {
        Navigator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
        workSpacesSettings = workSpaces.editWorkSpace(workspaceName);
        workSpacesSettings.updateWorkSpaceName(newName);
        workSpacesSettings.clickOnSaveButton();
    }

    /**
     * Mehtohd.
     *
     * @param message is the message.
     */
    @Then("^Confirm message should be \"([^\"]*)\"$")
    public void confirmMessageShouldBe(final String message) {
        Assert.assertTrue(workSpacesSettings.verifyChangesSavedMessage(message));
    }

    /**
     * Method.
     *
     * @param workspaceName is the name.
     */
    @And("^project name should be \"([^\"]*)\"$")
    public void projectNameShouldBe(final String workspaceName) {
        Assert.assertTrue(workSpacesSettings.verifyWorkspaceName(workspaceName));
    }

    /**
     * Method.
     *
     * @param workspaceName is the name.
     */
    @And("^\"([^\"]*)\" should be displayed$")
    public void shouldBeDisplayed(final String workspaceName) {
        Navigator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
        Assert.assertTrue(workSpaces.verifyIfAworkSpaceExist(workspaceName));
    }

    /**
     * Method.
     *
     * @param workspaceName is the name.
     */
    @And("^\"([^\"]*)\" should not be displayed$")
    public void shouldNotBeDisplayed(final String workspaceName) {
        dashBoard.clicOnWorkSpaces();
    }

    /**
     * Method.
     *
     * @param workspaceName is the name.
     */
    @When("^I navigate dashboard workspace and delete the \"([^\"]*)\"$")
    public void iNavigateDashboardWorkspaceAndDeleteThe(final String workspaceName) {
        dashBoard.clicOnWorkSpaces();
        workSpaces.editWorkSpace(workspaceName);
        workSpacesSettings.clickOnDeleteLink();
        workSpacesSettings.clickOnConfirmDeleteButton();
    }

    /**
     * Method.
     *
     * @param message is the name.
     */
    @Then("^Message should be \"([^\"]*)\"$")
    public void messageShouldBe(final String message) {
        assertEquals(dashBoard.verifyDeletionMessage(), message);
    }

    /**
     * Method.
     *
     * @param errorMessage the error message.
     */
    @Then("^Error message above should be \"([^\"]*)\"$")
    public void errorMessageAboveShouldBe(final String errorMessage) {
        workSpaces.verifySameNameWorkspaceName(errorMessage);
    }

    /**
     * Method.
     *
     * @param errorMessage is the error message.
     */
    @And("^Error message below shoud be \"([^\"]*)\"$")
    public void errorMessageBelowShoudBe(final String errorMessage) {
        Assert.assertFalse(workSpacesSettings.verifyChangesSavedMessage(errorMessage));
        Navigator.goToDashboard();
    }

    /**
     * Method.
     */


    @When("^I navigate to dashboard workspace$")
    public void iNavigateToDashboardWorkspace() {
        dashBoard.clicOnWorkSpaces();
    }

    /**
     * Method.
     *
     * @param body are the fields.
     */
    @And("^create a new worksapce as:$")
    public void createANewWorksapceAs(final Map<String, String> body) {
        workSpaces.clickOnCreateWorkspaceButton();
        workSpaces.setWorkspaceName(body.get("Name"));
        workSpaces.clickOnWorkspaceSubmitButton();
    }

}

