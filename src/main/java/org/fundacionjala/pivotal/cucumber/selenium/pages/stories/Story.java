package org.fundacionjala.pivotal.cucumber.selenium.pages.stories;

import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.fundacionjala.pivotal.cucumber.selenium.pages.stories.StorySetting.BLOCKERS;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.stories.StorySetting.DESCRIPTION;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.stories.StorySetting.LABEL;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.stories.StorySetting.NAME;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.stories.StorySetting.POINTS;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.stories.StorySetting.STORY_TYPE;

/**
 * Created by Administrator on 6/3/2017.
 */
public class Story extends AbstractBasePage {
  @FindBy(css = "div.sidebar_wrapper section ul li.item a.button.add_story")
  private WebElement addStoryButton;

  @FindBy(css = "div.tracker_markup.DescriptionShow__placeholder___1NuiicbF")
  private WebElement openDescriptionButton;

  @FindBy(css = "div button[data-aid='save']")
  private WebElement addDescriptionButton;

  @FindBy(css = "[data-type='search'] div.container section div div div.stories header a.selector")
  private WebElement deployStoryForDelete;

  @FindBy(css = "div.selectedStoriesControls__actions button.delete")
  private WebElement deleteStoryButton;

  @FindBy(css = "button[data-aid='DeleteButton']")
  private WebElement confirmDeleteStoryButton;

  @FindBy(css = "div.type.row div.dropdown.story_type")
  private WebElement deployStoryTypeButton;

  @FindBy(css = "div.estimate.row div.dropdown.story_estimate")
  private WebElement deployPointsButton;

  @FindBy(css = "div.requester.row div.dropdown.story_requested_by_id  div.name")
  private WebElement deployRequestButton;

  @FindBy(css = "div.owner.row div.story_owners a")
  private WebElement deployOwnersButton;

  @FindBy(css = "button.autosaves.button.std.save")
  private WebElement saveStoryButton;

  @FindBy(css = "div[data-focus-id='BlockerAdd']")
  private WebElement openBlockersButton;

  @FindBy(css = "textarea.editor.tracker_markup.std.name")
  private WebElement storyTitleTextField;

  @FindBy(css = "textarea[placeholder='Add a description']")
  private WebElement addDescriptionTextField;

  @FindBy(css = "div.type.row div.dropdown_menu.search div.search_item input")
  private WebElement storyTypeComboBox;

  @FindBy(css = "div.estimate.row div.dropdown.story_estimate section div.dropdown_menu div.search_item input")
  private WebElement pointsComboBox;

  @FindBy(css = "input.tn-text-input__field--medium___v3Ex3B7Z")
  private WebElement labelTextField;

  @FindBy(css = "textarea[data-aid='Blocker__textarea']")
  private WebElement blockersTextField;

  @FindBy(css = "div.requester.row div.dropdown.story_requested_by_id section div.dropdown_menu.search div input")
  private WebElement requestComboBox;

  @FindBy(id = "owners_search_field")
  private WebElement ownersComboBox;

  @FindBy(css = "[placeholder='Search project']")
  private WebElement searchProjectTextField;

  @FindBy(css = "span.name.tracker_markup span.story_name")
  private WebElement storyNameCreated;

  @FindBy(css = "ul.tn_sliding_list.tn_flash_messages")
  private WebElement messageDelete;

  @FindBy(css = "[data-type='search'] div.container section div div div.stories header a.expander")
  private WebElement deployStoryForUpdate;

  @FindBy(css = "button.autosaves.button.std.close")
  private WebElement autoUpdateAndCloseButton;

  @FindBy(css = "div[data-aid=\"AlertDialog__title\"]")
  private WebElement messageValidationError;

  @FindBy(css = "button[data-aid=\"AlertDialog__confirm\"]")
  private WebElement clickOkButtonToValidationError;


  /**
   * Click on Add Story.
   */

  public void setClickAddStory() {
    addStoryButton.click();
  }

  /**
   * Click for deploy request.
   */

  public void clickDeployRequester() {
    deployRequestButton.click();
  }

  /**
   * Click on text field to requester.
   *
   * @param requestName requestName.
   */

  public void clickWriteSelectRequester(final String requestName) {
    requestComboBox.sendKeys(requestName, Keys.ENTER);
  }

  /**
   * Click deploy owners.
   */

  public void clickDeployOwners() {
    CommonActions.clickElement(deployOwnersButton);
  }

  /**
   * Click on text field owners.
   *
   * @param ownersName ownersName.
   */

  public void clickWriteSelectOwners(final String ownersName) {
    ownersComboBox.sendKeys(ownersName, Keys.ENTER);
  }

  /**
   * Click on Save button.
   */

  public void clickSaveStory() {
    saveStoryButton.click();
  }

  /**
   * Delete stories.
   */

  public void clickDeleteStory() {
    deleteStoryButton.click();
  }

  /**
   * Confirm delete stories.
   */

  public void clickConfirmDeleteStory() {
    confirmDeleteStoryButton.click();
  }

  /**
   * Search stories id.
   *
   * @param storyId stories id.
   */

  public void searchStoryById(final String storyId) {
    searchProjectTextField.sendKeys(storyId, Keys.ENTER);
  }

  /**
   * Clear search stories id.
   */

  public void clearSearchStory() {
    searchProjectTextField.clear();
  }

  /**
   * Press Enter to search stories.
   */

  public void pressEnterSearchStory() {
    searchProjectTextField.sendKeys(Keys.ENTER);
  }

  /**
   * Close Story.
   */

  public void clickDelete() {
    CommonActions.clickElement(deployStoryForDelete);
  }

  /**
   * @return String to verify the stories created.
   */
  public String getMessageStoryCreated() {
    return storyNameCreated.getText();
  }

  /**
   * @return String to confirme the message delete.
   */
  public String getMessageDelete() {
    return messageDelete.getText();
  }

  /**
   * Method to deploy stories.
   */
  public void deployStory() {
    deployStoryForUpdate.click();
  }

  /**
   * Click on close button to update the stories.
   */
  public void clickAutoUpdateAndClose() {
    autoUpdateAndCloseButton.click();
  }

  /**
   * @return boolean to verify the message.
   */
  public String validationError() {
    return messageValidationError.getText();
  }

  /**
   * Method to click on the ok button to be able to create other stories.
   */
  public void clickOkToCreateNewStory() {
    clickOkButtonToValidationError.click();
  }

  /**
   * Executes the configurations sent.
   *
   * @param configureMap is a map that contains the configurations.
   */
  public void setConfigurationStory(final Map<StorySetting, String> configureMap) {
    Map<StorySetting, StoryStep> strategyOption = strategyConfigureSetting(configureMap);
    Set<StorySetting> keys = configureMap.keySet();
    for (StorySetting key : keys) {
      strategyOption.get(key).executeStoryStep();
    }
  }

  /**
   * Create an strategy steps configuration options filling a map with
   * all the existing configurations.
   *
   * @param configureMap is a map that contains all the configurations.
   * @return the configure map with strategies.
   */
  private Map<StorySetting, StoryStep> strategyConfigureSetting(
          final Map<StorySetting, String> configureMap) {
    Map<StorySetting, StoryStep> strategyMap = new HashMap<>();
    strategyMap.put(NAME, () -> insertNameStory(configureMap.get(NAME)));
    strategyMap.put(STORY_TYPE, () -> insertStoryTypeData(configureMap.get(STORY_TYPE)));
    strategyMap.put(POINTS, () -> insertPointData(configureMap.get(POINTS)));
    strategyMap.put(BLOCKERS, () -> insertBlockerData(configureMap.get(BLOCKERS)));
    strategyMap.put(DESCRIPTION, () -> insertDescription(configureMap.get(DESCRIPTION)));
    strategyMap.put(LABEL, () -> insertLabelData(configureMap.get(LABEL)));

    return strategyMap;
  }

  /**
   * @param name of the story.
   */
  public void insertNameStory(final String name) {
    storyTitleTextField.clear();
    storyTitleTextField.sendKeys(name);
  }

  /**
   * @param storyType of the story.
   */
  public void insertStoryTypeData(final String storyType) {
    CommonActions.clickElement(deployStoryTypeButton);
    storyTypeComboBox.sendKeys(storyType, Keys.ENTER);
  }

  /**
   * @param point of the story.
   */
  public void insertPointData(final String point) {
    CommonActions.clickElement(deployPointsButton);
    pointsComboBox.sendKeys(point, Keys.ENTER);
  }

  /**
   * @param blocker of the story.
   */
  public void insertBlockerData(final String blocker) {
    openBlockersButton.click();
    this.blockersTextField.sendKeys(blocker, Keys.ENTER);
  }

  /**
   * @param description of the story.
   */
  public void insertDescription(final String description) {
    openDescriptionButton.click();
    CommonActions.setTextField(addDescriptionTextField, description);
    addDescriptionButton.click();
  }

  /**
   * @param label of the story.
   */
  public void insertLabelData(final String label) {
    labelTextField.clear();
    this.labelTextField.sendKeys(label, Keys.ENTER);
  }
}
