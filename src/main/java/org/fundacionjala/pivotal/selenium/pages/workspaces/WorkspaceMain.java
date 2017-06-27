package org.fundacionjala.pivotal.selenium.pages.workspaces;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;

/**
 * Created by Administrator on 6/16/2017.
 */
public class WorkspaceMain extends AbstractBasePage {
    /**
     * Locate webElement.
     */
    @FindBy(css = ".new_workspace>p>button")
    private WebElement addProjectButton;

    /**
     * Locate webElement.
     */
    @FindBy(css = "li.Smnpz__DropdownMenuOption")
    private List<WebElement> projectList;

    /**
     * Locate webElement.
     */
    @FindBy(css = "section.add_projects  a[data-aid='projectDropdown']")
    private WebElement projectDropdown;


    /**
     * Locate webElement.
     */
    @FindBy(css = "span.raw_context_name")
    private WebElement workSpaceName;

    /**
     * Locate webElement.
     */
    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement pivotalLogo;

    /**
     * Locate webElement.
     */
    @FindBy(id = "workspace_settings")
    private WebElement workSpaceSettingsButton;

    /**
     * Locate webElement.
     */
    @FindBy(css = "a.add_projects")
    private WebElement workspacesAddButton;

    /**
     * Locate webElement.
     */
    @FindBy(css = "li.edit_project")
    private List<WebElement> projectsList;

    /**
     * Locate webElement.
     */
    @FindBy(css = "._3lvre__projectNav__toggle")
    private WebElement toggleButton;
    /**
     * Locator.
     */
    @FindBy(css = ".save")
    private WebElement saveButton;

    /**
     * Click on addproject button.
     */
    public void clickOnAddProjectButton() {

        CommonActions.clickElement(addProjectButton);
    }

    /**
     * ChooseAprojectToadd.
     *
     * @param projectName is the project name.
     */
    public void choseAprojectToAdd(final String projectName) {
        CommonActions.selectAnElement(projectList, projectName).click();
    }

    /**
     * Click on the project dropdown.
     */
    public void clickOnProjectsDropDown() {
        CommonActions.clickElement(projectDropdown);
    }

    /**
     * Choose more than one project to add.
     *
     * @param projectName is the list of the projects.
     */
    public void choseMoreThanOneprojectsToAdd(final String[] projectName) {
        int zero = 0;
        for (int i = zero; i < projectName.length; i++) {
            clickOnProjectsDropDown();
            wait.until(ExpectedConditions.
                    presenceOfElementLocated(By.
                            cssSelector("ul._1VtS8__DropdownMenu__menuList")));
            CommonActions.selectAnElement(projectList, projectName[i]).click();
        }
    }

    /**
     * click on workspaces settings button.
     */
    public void clickOnWorkSpacesSettingsButton() {
        CommonActions.clickOnaHiddenElement(workSpaceSettingsButton);
    }

    /**
     * click on add project on the work space button.
     */
    public void clickOnAddProjectsOnWorkSpaceButton() {
        CommonActions.clickOnaHiddenElement(workspacesAddButton);
    }

    /**
     * Click on save to add project to workspace button.
     */
    public void clickOnSaveButton() {
        CommonActions.clickElement(saveButton);
    }

}
