package org.fundacionjala.pivotal.stepdefinitions.ui.workspaces;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.selenium.pages.common.Navigator;
import org.fundacionjala.pivotal.selenium.pages.workspaces.WorkSpacesSettings;
import org.fundacionjala.pivotal.selenium.pages.workspaces.Workspaces;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 7/5/2017.
 */
public class WorkSpacesAsertions {


    private Dashboard dashBoard;

    private Workspaces workspaces;

    private WorkSpacesSettings workSpacesSettings;

    /**
     * Constructor.
     *
     * @param dashboard          class
     * @param workspaces         class
     * @param workSpacesSettings class
     */
    public WorkSpacesAsertions(final Dashboard dashboard, final Workspaces workspaces, final WorkSpacesSettings
            workSpacesSettings) {
        this.dashBoard = dashboard;
        this.workspaces = workspaces;
        this.workSpacesSettings = workSpacesSettings;
    }

    /**
     * Step.
     *
     * @param message is the message displayed.
     */

    @Then("^Error message should be \"([^\"]*)\"$")
    public void errorMessageShouldBe(final String message) {
        String messageWorkspace = workspaces.getWorkSpaceBlankNameError();
        Navigator.goToDashboard();
        assertEquals(message, messageWorkspace);
    }

    /**
     * Step.
     *
     * @param message is the message displayed.
     */
    @Then("^Error message must be \"([^\"]*)\"$")
    public void errorMessageMustBe(final String message) {
        String messageWorkspace = workspaces.getWorkspaceTakenNameMessage();
        Navigator.goToDashboard();
        assertEquals(message, messageWorkspace);
    }

    /**
     * Step.
     *
     * @param workspaceName is the name of workspace.
     */
    @Then("^\"([^\"]*)\" should be displayed$")
    public void shouldBeDisplayed(final String workspaceName) {
        Navigator.goToDashboard();
        dashBoard.clicOnWorkSpaces();
        assertTrue(workspaces.verifyIfAworkSpaceExist(workspaceName));
    }

    /**
     * Step.
     *
     * @param errorMessage is the message displayed.
     */

    @Then("^Error message above should be \"([^\"]*)\"$")
    public void errorMessageAboveShouldBe(final String errorMessage) {
        assertEquals(workspaces.getWorkspaceTakenNameMessage(), errorMessage);
        //  workSpaces.verifySameNameWorkspaceName(errorMessage);
    }

    /**
     * Step.
     *
     * @param errorMessage is the message displayed.
     */
    @And("^Error message below shoud be \"([^\"]*)\"$")
    public void errorMessageBelowShoudBe(String errorMessage) {
        assertEquals(workSpacesSettings.verifyErrorSavedMessage(), errorMessage);
        Navigator.goToDashboard();
    }

    /**
     * Step.
     *
     * @param workspaceName the name.
     */
    @Then("^\"([^\"]*)\" should not be displayed$")
    public void shouldNotBeDisplayed(final String workspaceName) {
        Navigator.goToDashboard();
        dashBoard.clicOnWorkSpaces();


    }
}
