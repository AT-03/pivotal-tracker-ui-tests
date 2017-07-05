package org.fundacionjala.pivotal.stepdefinitions.ui.stories;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.selenium.pages.stories.Story;

import static org.junit.Assert.assertEquals;

/**
 * Created by PC on 05/07/2017.
 */
public class StoryAssertions {

    private Story initStory;

    /**
     * StoryAssertions constructor.
     * @param initStory value.
     */
    public StoryAssertions(Story initStory) {
        this.initStory = initStory;
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
}
