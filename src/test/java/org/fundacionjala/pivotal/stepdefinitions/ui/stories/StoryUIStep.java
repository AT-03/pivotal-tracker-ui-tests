package org.fundacionjala.pivotal.stepdefinitions.ui.stories;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.selenium.pages.stories.Story;
import org.fundacionjala.pivotal.selenium.pages.stories.StorySetting;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by FERNANDO on 8/6/17.
 */
public class StoryUIStep {

  private Dashboard initDastBoard;
  private Story initStory;
  private Response response;
  private Map<StorySetting, String> settingMap;

  /**
   * @param dashBoard in the contructor StoryUIStep.
   * @param story     in the contructor.
   */
  public StoryUIStep(final Dashboard dashBoard, final Story story) {
    this.initDastBoard = dashBoard;
    this.initStory = story;
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
   * @param newSettingMap SettingMap that contains the setting for stories.
   */
  @And("^I insert the datas for the Story$")
  public void iAddedANewProject(final Map<StorySetting, String> newSettingMap) {
    settingMap = newSettingMap;
    initStory.setClickAddStory();
    initStory.setConfigurationStory(settingMap);
    //Insert Requester
    initStory.clickDeployRequester();
    initStory.clickWriteSelectRequester(getName());
    //Insert Owners
    initStory.clickDeployOwners();
    initStory.clickWriteSelectOwners(getName());
    initStory.clickSaveStory();
  }

  /**
   * Method to search the stories to update.
   *
   * @param storyname for the stories.
   */
  @And("^I search Story with the name \"(.*)\"$")
  public void searchStory(final String storyname) {
    initStory.clearSearchStory();
    initStory.searchStoryById(storyname);
    initStory.pressEnterSearchStory();
    initStory.deployStory();
  }

  /**
   * Method to click on close button to update the stories.
   */
  @And("^I click on Close button to update the Story$")
  public void updateStory() {
    initStory.clickAutoUpdateAndClose();
  }

  /**
   * Method to search a stories to delete.
   *
   * @param storyname to search a stories.
   */
  @And("^I search a Story with the name \"(.*)\" to delete it$")
  public void searchStoryToDelete(final String storyname) {
    initStory.searchStoryById(storyname);
    initStory.pressEnterSearchStory();
  }

  /**
   * Method to verify if the stories was created.
   *
   * @param storyCreated to verify if the stories was created.
   */
  @Then("^Verify if the story was created with the name \"(.*)\"$")
  public void verifyStoryCreated(final String storyCreated) {
    String message = initStory.getMessageStoryCreated();
    assertEquals(storyCreated, message);
  }

  /**
   * Method to verify if the message should be validation Error.
   *
   * @param validationError to verify if the message should be validation Error.
   */
  @Then("^Verify if the message should be \"(.*)\"$")
  public void verifyMessageValidationError(final String validationError) {
    String message = initStory.validationError();
    assertEquals(validationError, message);
    initStory.clickOkToCreateNewStory();
  }

  /**
   * Method to show if the message should be stories deleted.
   *
   * @param deleted to show a message that the stories was deleted.
   */
  @Then("^The message should be \"(.*)\"$")
  public void theStoryShouldBeDeleted(final String deleted) {
    String message = initStory.getMessageDelete();
    assertEquals(deleted, message);
  }

  /**
   * @return String method to get the name from profile user.
   */
  public String getName() {
    String name = "";
    response = RequestManager.get("/me");
    name = response.jsonPath().getJsonObject("name");
    return name;
  }

  /**
   * This method delete a stories.
   */
  @When("^I delete a story$")
  public void deleteStory() {
    initStory.clickDelete();
    initStory.clickDeleteStory();
    initStory.clickConfirmDeleteStory();
  }
}
