package org.fundacionjala.pivotal.cucumber.selenium.pages;

import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

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

    @FindBy(css = "[data-type='search'] div.container section div div div.story header a.selector")
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

    @FindBy(css = ".expander.undraggable")
    private WebElement deployStoryButton;

    @FindBy(css = ".dropdown.story_type")
    private WebElement storyTypeNameLabel;

    @FindBy(css = "[placeholder='Search project']")
    private WebElement searchProjectTextField;

    @FindBy(css = ".autosaves.button.std.close")
    private WebElement closeStoryButton;

    @FindBy(css = "[data-aid='Tasks'] [data-aid='TaskAdd']")
    private WebElement deployAddTaskButton;

    @FindBy(css = "span.name.tracker_markup span.story_name")
    private WebElement storyNameCreated;

    @FindBy(css = "ul.tn_sliding_list.tn_flash_messages")
    private WebElement messageDelete;

    @FindBy(css = "div button[data-aid='save']")
    private WebElement addUpdateDescriptionButton;

    @FindBy(css = "section.description.full div div.tracker_markup")
    private WebElement openUpdateDescriptionTextField;

    @FindBy(css = "[data-type='search'] div.container section div div div.story header a.expander")
    @CacheLookup
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
        //CommonActions.clickElement(deployRequestButton);
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
     * Write and add description.
     *
     * @param addDescription addDescription.
     */

    public void writeAddDescription(final String addDescription) {
        CommonActions.setTextField(addDescriptionTextField, addDescription);
    }

    /**
     * Click for deploy description.
     */
    public void clickDeployDescription() {
        openDescriptionButton.click();
    }

    /**
     * @param map insert data for the story.
     */
    public void insertDataForStory(final Map<String, String> map) {
        for (Map.Entry m : map.entrySet()) {
            String value = (String) m.getValue();
            String key = (String) m.getKey();
            switch (key) {
                case "name":
                    storyTitleTextField.clear();
                    storyTitleTextField.sendKeys(value);
                    break;
                case "Story Type":
                    CommonActions.clickElement(deployStoryTypeButton);
                    storyTypeComboBox.sendKeys(value, Keys.ENTER);
                    break;
                case "Points":
                    CommonActions.clickElement(deployPointsButton);
                    pointsComboBox.sendKeys(value, Keys.ENTER);
                    break;
                case "Blockers":
                    openBlockersButton.click();
                    this.blockersTextField.sendKeys(value, Keys.ENTER);
                    break;
                case "Description":
                    openDescriptionButton.click();
                    CommonActions.setTextField(addDescriptionTextField, value);
                    addDescriptionButton.click();
                    break;
                case "Label":
                    labelTextField.clear();
                    this.labelTextField.sendKeys(value, Keys.ENTER);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Click on Save button.
     */

    public void clickSaveStory() {
        saveStoryButton.click();
    }

    /**
     * Delete story.
     */

    public void clickDeleteStory() {
        deleteStoryButton.click();
    }

    /**
     * Confirm delete story.
     */

    public void clickConfirmDeleteStory() {
        confirmDeleteStoryButton.click();
    }

    /**
     * Search story id.
     *
     * @param storyId story id.
     */

    public void searchStoryById(final String storyId) {
        searchProjectTextField.sendKeys(storyId, Keys.ENTER);
    }

    /**
     * Clear search story id.
     */

    public void clearSearchStory() {
        searchProjectTextField.clear();
    }

    /**
     * Press Enter to search story.
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
     * @param storyCreated to confirme the story created.
     * @return boolean to verify the story created.
     */
    public boolean verifyStoryCreated(final String storyCreated) {
        return CommonActions.verifyMessages(storyNameCreated, storyCreated);
    }

    /**
     * @param deleted to confirme the message to delete a story.
     * @return boolean to confirme the message delete.
     */
    public boolean getMessageDelete(final String deleted) {
        return CommonActions.verifyMessages(messageDelete, deleted);
    }

    /**
     * Method close driver.
     */
    public void driverClose() {
        DriverManager.getInstance().getDriver().close();
    }

    /**
     * Method to click update to add description.
     */
    public void clickUpdateAddDescription() {
        addUpdateDescriptionButton.click();
    }

    /**
     * Method to deploy story.
     */
    public void deployStory() {
        deployStoryForUpdate.click();
    }

    /**
     * Click on close button to update the story.
     */
    public void clickAutoUpdateAndClose() {
        autoUpdateAndCloseButton.click();
    }

    /**
     * @param validationError method to show a message.
     * @return boolean to verify the message.
     */
    public boolean validationError(final String validationError) {
        return CommonActions.verifyMessages(messageValidationError, validationError);
    }

    /**
     * Method to click on the ok button to be able to create other story.
     */
    public void clickOkToCreateNewStory() {
        clickOkButtonToValidationError.click();
    }
}
