package org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.stories;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.pivotal.cucumber.api.RequestManager;
import org.fundacionjala.pivotal.cucumber.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.cucumber.selenium.pages.SignIn;
import org.fundacionjala.pivotal.cucumber.selenium.pages.Story;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navegator;

import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by FERNANDO on 8/6/17.
 */
public class StepDefinition {

    private Dashboard initDastBoard;
    private Story initStory;
    private Response response;

    /**
     * @param dashBoard in the contructor StepDefinition.
     * @param story in the contructor.
     */
    public StepDefinition(final Dashboard dashBoard, final Story story) {
        this.initDastBoard = dashBoard;
        this.initStory = story;
    }

    /**
     * @param user to login to the pivotaltracker.
     */
    @Given("^I login to pivotalTracker as \"([^\"]*)\"$")
    public void iLoginToPivotalAs(final String user) {
        initDastBoard = SignIn.loginOtherUser();

    }

    /**
     * Method to refresh to navigate to the dashboard page.
     */
    @And("^I go to DashBoard$")
    public void refreshDasboard() {
        Navegator.goToDashboard();
    }

    /**
     * Method to open a project created.
     *
     * @param project of the project created.
     */
    @Then("^Open a project created as \"(.*)\"$")
    public void openProject(final String project) {
        initDastBoard.searchForAProject(project);
        initStory = initDastBoard.clickSearchProject();

    }

    /**
     * Method to click on th button add story.
     */
    @When("^I click on the button Add Story$")
    public void clickOnButtonAddStory() {
        initStory.setClickAddStory();
    }

    /**
     * Method to change the description for the story updated.
     *
     * @param description to change the description of the story.
     */
    @And("^I change the Description as \"(.*)\"$")
    public void changeTheDescription(final String description) {
        initStory.clickDeployDescription();
        initStory.writeAddDescription(description);
        initStory.clickUpdateAddDescription();
    }

    /**
     * Method to save the story created.
     */
    @And("^I save the Story$")
    public void saveStory() {
        initStory.clickSaveStory();
    }

    /**
     * Method to search the story to update.
     *
     * @param storyname for the story.
     */
    @When("^I search Story with the name \"(.*)\"$")
    public void searchStory(final String storyname) {
        initStory.clearSearchStory();
        initStory.searchStoryById(storyname);
        initStory.pressEnterSearchStory();
        initStory.deployStory();
    }

    /**
     * Method to click on close button to update the story.
     */
    @And("^I click on Close button to update the Story$")
    public void updateStory() {
        initStory.clickAutoUpdateAndClose();
    }

    /**
     * Method to click on checkbox of the story created.
     */
    @And("^I click on checkBox of the Story created$")
    public void clickCheckBoxDeleteStory() {
        initStory.clickDelete();
    }

    /**
     * Method to click on the button delete.
     */
    @And("^I click on the button Delete$")
    public void deleteStory() {
        initStory.clickDeleteStory();
    }

    /**
     * Method to click on confirm button to delete the story.
     */
    @Then("^I click on confirm button to delete the story$")
    public void confirmDeleteStory() {
        initStory.clickConfirmDeleteStory();
    }

    /**
     * Method to search a story to delete.
     *
     * @param storyname to search a story.
     */
    @When("^I search a Story with the name \"(.*)\" to delete it$")
    public void searchStoryToDelete(final String storyname) {
        initStory.searchStoryById(storyname);
        initStory.pressEnterSearchStory();
    }

    /**
     * Method to verify if the story was created.
     *
     * @param storyCreated to verify if the story was created.
     */
    @Then("^Verify if the story was created with the name \"(.*)\"$")
    public void verifyStoryCreated(final String storyCreated) {
        assertTrue(initStory.verifyStoryCreated(storyCreated));
    }

    /**
     * Method to verify if the message should be validation Error.
     *
     * @param validationError to verify if the message should be validation Error.
     */
    @Then("^Verify if the message show it should be \"(.*)\"$")
    public void verifyMessageValidationError(final String validationError) {
        assertTrue(initStory.validationError(validationError));
        initStory.clickOkToCreateNewStory();
    }

    /**
     * Method to verify if the story was update.
     *
     * @param storyCreated to verify if the story was update.
     */
    @Then("^Verify if the story was Update with the name \"(.*)\"$")
    public void verifyStoryUpdate(final String storyCreated) {
        assertTrue(initStory.verifyStoryCreated(storyCreated));
    }

    /**
     * Method to show if the message should be story deleted.
     *
     * @param deleted to show a message that the story was deleted.
     */
    @Then("^The message should be \"(.*)\"$")
    public void theStoryShouldBeDeleted(final String deleted) {
        assertTrue(initStory.getMessageDelete(deleted));
        initStory.driverClose();
    }

    /**
     * Method to insert datas to create Stories.
     *
     * @param map to get the datas from the DataTable
     */
    @And("^I insert the datas for the Story$")
    public void insertDataTOCreateStory(final Map<String, String> map) {
        initStory.insertDataForStory(map);
        //Insert Requester
        initStory.clickDeployRequester();
        initStory.clickWriteSelectRequester(getName());
        //Insert Owners
        initStory.clickDeployOwners();
        initStory.clickWriteSelectOwners(getName());

    }

    /**
     * @return String method to get the name from profile user.
     */
    public String getName() {
        String name = "";
        response = RequestManager.get("/me");
        name = response.jsonPath().getJsonObject("name");
        System.out.print(name);
        return name;
    }
}
