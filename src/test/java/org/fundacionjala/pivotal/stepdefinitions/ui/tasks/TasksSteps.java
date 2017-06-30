package org.fundacionjala.pivotal.stepdefinitions.ui.tasks;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.selenium.pages.Dashboard;
import org.fundacionjala.pivotal.selenium.pages.stories.StoryDashboard;

/**
 * Created by Administrator on 6/16/2017.
 */
public class TasksSteps {

    private Dashboard dashboard;

    private StoryDashboard storyDashboard;

    /**
     * Constructor.
     *
     * @param dashboard      dashboard.
     * @param storyDashboard story dashboard.
     */

    public TasksSteps(final Dashboard dashboard, final StoryDashboard storyDashboard) {
        this.dashboard = dashboard;
        this.storyDashboard = storyDashboard;
    }

    /**
     * Open a project and story.
     *
     * @param storyName story name.
     */
    @Given("^I open a story with name as \"([^\"]*)\"$")
    public void iOpenAStoryWithNameAs(final String storyName) {
        storyDashboard.searchStory(storyName);
        storyDashboard.clickSelectStory();
    }

    /**
     * Write a task or multiple tasks.
     *
     * @param taskName task name.
     */
    @When("^I write a or multiple task and press Enter with a following names$")
    public void iWriteAOrMultipleTaskAndPressEnterWithAFollowingNameS(final List<String> taskName) {
        storyDashboard.clickOpenTask();
        List<String> strings = new ArrayList<>();
        strings.addAll(taskName);
        storyDashboard.writeMultipleAddTask(strings);
    }

    /**
     * Close story.
     */
    @Then("^I close the story$")
    public void iCloseStory() {
        storyDashboard.closeStory();
    }

    /**
     * Update task.
     *
     * @param taskName   task to update.
     * @param taskUpdate new task name.
     */

    @And("^I update the next task \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iUpdateTheNextTaskWith(final String taskName, final String taskUpdate) {
        storyDashboard.clickUpdateTask(taskName, taskUpdate);
    }

    /**
     * Task to delete.
     *
     * @param taskDelete task name delete.
     */
    @When("^I delete the next task \"([^\"]*)\"$")
    public void iDeleteTheNextTask(final String taskDelete) {
        storyDashboard.mouseOverTaskDelete(taskDelete);
    }

    /**
     * Open project.
     *
     * @param projectName project name.
     */
    @Given("^I open a project with name as \"([^\"]*)\"$")
    public void iOpenAProjectWithNameAs(final String projectName) {
        dashboard.searchForAProject(projectName);
        storyDashboard = dashboard.clickSelectProject();
    }

}
