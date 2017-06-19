package org.fundacionjala.pivotal.cucumber.selenium.pages.workspaces;

import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 6/16/2017.
 */
public class Workspaces extends AbstractBasePage {

  /**
   * Locator.
   */
  @FindBy(id = "create-workspace-button")
  private WebElement createWorkSpaceButton;

  /**
   * Locator.
   */
  @FindBy(css = ".WorkspaceTile__header")
  private List<WebElement> workspaceHeader;

  /**
   * Locator.
   */
  @FindBy(css = ".tc-form__input")
  private WebElement workspaceNameFiled;

  /**
   * Locator.
   */
  @FindBy(css = "button[type='submit']")
  private WebElement submitWorkspaceButton;

  /**
   * Locator.
   */
  @FindBy(css = "button[type='button']")
  private WebElement cancelWorkspaceButton;

  /***
   * Click to create a workspace.
   */
  public void clickOnCreateWorkspaceButton() {
    CommonActions.clickElement(createWorkSpaceButton);
  }

  /**
   * This method set the workspace name.
   *
   * @param workspaceName is the name of the workspace to be created.
   */
  public void setWorkspaceName(final String workspaceName) {
    CommonActions.setTextField(workspaceNameFiled, workspaceName);
  }

  /**
   * This method clicks on the create workspace submit button.
   *
   * @return a new instance the Workspace main class.
   */
  public WorkspaceMain clickOnWorkspaceSubmitButton() {
    CommonActions.clickElement(submitWorkspaceButton);
    return new WorkspaceMain();
  }

  /**
   * This method clicks on the cancel button.
   */
  public void clickOnCancelWorkspaceButton() {
    CommonActions.clickElement(cancelWorkspaceButton);
  }

  /**
   * Enter on the  workspace settings page.
   *
   * @param workSpaceNewName is the new name.
   * @return a new instace of workspaces settings class.
   */
  public WorkSpacesSettings onSettings(final String workSpaceNewName) {
    CommonActions.selectAnElement(workspaceHeader, workSpaceNewName)
            .findElement(By.cssSelector(".SettingsIcon__cog."
                    + "projectTileHeader__hoverable"))
            .click();
    return new WorkSpacesSettings();
  }
}
