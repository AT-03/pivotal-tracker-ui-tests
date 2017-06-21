package org.fundacionjala.pivotal.cucumber.selenium.pages;

import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 6/14/2017.
 */
public class Dashboard extends AbstractBasePage {

    /**
     * Locator.
     */
    @FindBy(id = "create-project-button")
    private WebElement createProjectButton;

    /**
     * Locator.
     */
    @FindBy(id = "projects-search-bar")
    private WebElement projectSearchBar;

    /**
     * Locator.
     */
    @FindBy(css = "button.SelectBox__button")
    private WebElement selectTypeProjectButton;

    /**
     * Locator.
     */
    @FindBy(css = "a.projectTileHeader__projectName")
    private List<WebElement> projectNameList;

    /**
     * Locator.
     */
    @FindBy(css = "div.Dashboard__Tabs span")
    private List<WebElement> workSpacesLink;

    /**
     * Locator.
     */
    @FindBy(css = "a.projectTileHeader__projectName.projectTileHeader__projectName--active")
    private WebElement selectProject;

    @FindBy(css = "[placeholder='Search project']")
    private WebElement searchProjectTextField;

    @FindBy(css = "[data-type='search'] div.container section div div div.story header a.expander")
    @CacheLookup
    private WebElement deployStoryForUpdate;

    /**
     * Locator.
     */
    @FindBy(css = "#notice")
    private WebElement deletionMessage;

    /**
     * click on create project button.
     *
     * @return ProjectForm project Form instance
     */
    public ProjectForm clickOnCreateProjectButton() {
        CommonActions.clickElement(createProjectButton);
        return new ProjectForm();
    }

    /**
     * Search a project on the search bar.
     *
     * @param project is the name of the project.
     */
    public void searchForAProject(final String project) {
        CommonActions.setTextField(projectSearchBar, project);
    }

    /**
     * selec a project by click on its header.
     *
     * @param projectName is the name of the project.
     */
    public void selecAproject(final String projectName) {
        CommonActions.selectAnElement(projectNameList, projectName).click();
    }

    /**
     * Click on workspaces.
     */
    public void clicOnWorkSpaces() {
        CommonActions.selectAnElement(workSpacesLink, "Workspaces").click();
    }

    /**
     * Click on element.
     *
     * @return story Dashboard.
     */
    public StoryDashboard clickSelectProject() {
        CommonActions.clickElement(selectProject);
        return new StoryDashboard();
    }

    /**
     * Verify the message.
     *
     * @param message is the message
     * @return true or false.
     */
    public boolean verifyDeletionMessage(final String message) {
        return CommonActions.verifyMessages(deletionMessage, message);
    }

}
