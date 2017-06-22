package org.fundacionjala.workspaces;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.cucumber.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navegator;
import org.fundacionjala.pivotal.cucumber.selenium.pages.workspaces.WorkSpacesSettings;
import org.fundacionjala.pivotal.cucumber.selenium.pages.workspaces.WorkspaceMain;

import org.fundacionjala.pivotal.cucumber.selenium.pages.workspaces.Workspaces;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 6/20/2017.
 */
public class WorkspacesUIStepts {


    private Dashboard dashBoard = new Dashboard();
    private Workspaces workSpaces = new Workspaces();
    private WorkSpacesSettings workSpacesSettings = new WorkSpacesSettings();
    private WorkspaceMain workspaceMain = new WorkspaceMain();


    /**
     * Metod.
     *
     * @param body the map.
     */
    @When("^I navigate to dashboard workspace and create a new worksapce as:$")
    public void iNavigateToDashboardWorkspaceAndCreateANewWorksapceAs(final Map<String, String> body) {
        Navegator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
        workSpaces.clickOnCreateWorkspaceButton();
        workSpaces.setWorkspaceName(body.get("Name"));
        workSpaces.clickOnWorkspaceSubmitButton();
    }

    /**
     * Method.
     *
     * @param workspaceName the name.
     */
    @Then("^\"([^\"]*)\" should be displayed in dashboard workspace$")
    public void shouldBeDisplayedInDashboardWorkspace(final String workspaceName) {
        Navegator.goToDashboard();
        Navegator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
        workSpaces.selectAworkSpace(workspaceName);
        Navegator.goToDashboard();
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
        Navegator.goToDashboard();
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
        Navegator.goToDashboard();
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
        Navegator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
//        Assert.assertFalse(workSpaces.verifyIfAworkSpaceExist(workspaceName));
    }

    /**
     * Method.
     *
     * @param workspaceName is the name.
     */
    @When("^I navigate dashboard workspace and delete the \"([^\"]*)\"$")
    public void iNavigateDashboardWorkspaceAndDeleteThe(final String workspaceName) {
        Navegator.goToDashboard();
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
        System.out.println(message);
        Assert.assertTrue(dashBoard.verifyDeletionMessage(message));
    }

    /**
     * Method.
     *
     * @param errorMessage is the error message.
     */
    @Then("^Error message should be \"([^\"]*)\"$")
    public void errorMessageShouldBe(final String errorMessage) {
        workSpaces.verifyWorkSpaceBankNameError(errorMessage);
        Navegator.goToDashboard();
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
        Navegator.goToDashboard();
    }

    /**
     * Method.
     */
    @When("^I navigate to  workspace on the dashboard and i select a workspace$")
    public void iNavigateToWorkspaceOnTheDashboardAndISelectAWorkspace() {
        Navegator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
    }

    /**
     * Method.
     *
     * @param workspaceName is the workspace name.
     * @param dataTable     is the table.
     */
    @And("^I add multiple projects on \"([^\"]*)\"$")
    public void iAddMultipleProjectsOn(final String workspaceName, final DataTable dataTable) {
        workSpaces.selectAworkSpace(workspaceName);
        workspaceMain.clickOnAddProjectButton();
        List<List<String>> data = dataTable.raw();
        workspaceMain.choseMoreThanOneprojectsToAdd(new String[]
                {data.get(0).get(0), data.get(0).get(1), data.get(0).get(2)});
        workspaceMain.clickOnSaveButton();
        Navegator.goToDashboard();
    }
}
