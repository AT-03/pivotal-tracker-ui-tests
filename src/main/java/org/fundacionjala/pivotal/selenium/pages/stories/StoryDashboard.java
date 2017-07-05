package org.fundacionjala.pivotal.selenium.pages.stories;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;

/**
 * Created by Administrator on 6/16/2017.
 */
public class StoryDashboard extends AbstractBasePage {

    @FindBy(css = "[data-aid='new']")
    private WebElement addTaskTextField;

    @FindBy(css = ".autosaves.button.std.close")
    private WebElement closeStoryButton;

    @FindBy(css = "[placeholder='Search project']")
    private WebElement searchProjectTextField;

    @FindBy(css = "[data-type='search'] div.container section div div div.story header a.expander")
    @CacheLookup
    private WebElement deployStoryForUpdate;

    @FindBy(css = "[data-aid='Tasks'] [data-aid='TaskAdd']")
    private WebElement openAddTaskButton;

    @FindBy(css = "[data-aid='TaskDescription']")
    private List<WebElement> taskList;

    @FindBy(css = "[data-aid='editor']")
    private WebElement taskUpdateButton;

    @FindBy(css = "span[data-aid='delete']")
    private WebElement deleteTaskButton;

    @FindBy(css = "[class=\"magnify\"]")
    private WebElement searchProjectButton;

    /**
     * Write a task or multiple tasks.
     *
     * @param taskName task name.
     */
    public void writeMultipleAddTask(final List<String> taskName) {
        for (String task : taskName) {
            CommonActions.setTextField(addTaskTextField, task);
            addTaskTextField.sendKeys(Keys.ENTER);
        }
    }

    /**
     * Close story window.
     */
    public void closeStory() {
        CommonActions.clickElement(closeStoryButton);
    }

    /**
     * Click on story selected.
     */
    public void clickSelectStory() {
        CommonActions.clickElement(deployStoryForUpdate);
    }

    /**
     * Click on open task.
     */
    public void clickOpenTask() {
        CommonActions.clickElement(openAddTaskButton);
    }

    /**
     * Update Task.
     *
     * @param taskName   task name.
     * @param taskUpdate new task name.
     */
    public void clickUpdateTask(final String taskName, final String taskUpdate) {
        WebElement element = CommonActions.selectAnElement(taskList, taskName);
        if (element != null) {
            element.click();
            CommonActions.setTextField(taskUpdateButton, taskUpdate);
            taskUpdateButton.sendKeys(Keys.ENTER);
        }
    }

    /**
     * Mouse over to delete task.
     *
     * @param taskDelete task name delete.
     */
    public void mouseOverTaskDelete(final String taskDelete) {
        WebElement element = CommonActions.selectAnElement(taskList, taskDelete);
        Action action = new Actions(driver)
                .moveToElement(element)
                .click(deleteTaskButton)
                .build();
        action.perform();
    }

    /**
     * Search story by name.
     *
     * @param storyName story name.
     */
    public void searchStory(final String storyName) {
        CommonActions.sleep();
        CommonActions.setTextField(searchProjectTextField, storyName);
        CommonActions.clickElement(searchProjectButton);
    }
}
