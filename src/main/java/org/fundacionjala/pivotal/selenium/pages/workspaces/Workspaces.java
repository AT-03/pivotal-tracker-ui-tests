package org.fundacionjala.pivotal.selenium.pages.workspaces;


import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;

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

    /**
     * Locator.
     */
    @FindBy(css = ".WorkspaceTile__name")
    private List<WebElement> workSpacesList;

    /**
     * Locator.
     */
    @FindBy(css = "div.tc-form__input--error-message span")
    private WebElement worksapaceCantBeBlankMessage;

    /**
     * Locator.
     */
    @FindBy(xpath = "//span[text()='The workspace name you entered is already taken.']")
    private WebElement workspaceNameisTakenMessage;

    /**
     * Locator.
     */
    @FindBy(css = ".error_above_or_below")
    private WebElement errorAboveorBelow;

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

    /**
     * Select a workspace.
     *
     * @param workSpaceName is the name of the workspace.
     */
    public void selectAworkSpace(final String workSpaceName) {
        CommonActions.selectAnElement(workSpacesList, workSpaceName).click();
    }

    /**
     * Verify if the now spane is show in the dashboard.
     *
     * @param workSpaceName is the workspace name
     * @return true if the workspace exist or false if not.
     */
    public boolean verifyIfAworkSpaceExist(final String workSpaceName) {
        return CommonActions.selectAnElement(workSpacesList, workSpaceName).isDisplayed();
//        boolean response = false;
//        if (CommonActions.selectAnElement(workSpacesList, workSpaceName).isDisplayed()) {
//            response = true;
//        }
//        return response;
    }

    /**
     * edit the worksapace.
     *
     * @param workSpaceNewName the name of workspace
     * @return the workspace.
     */
    public WorkSpacesSettings editWorkSpace(final String workSpaceNewName) {
        CommonActions.selectAnElement(workspaceHeader, workSpaceNewName)
                .findElement(By.cssSelector(".SettingsIcon__cog."
                        + "projectTileHeader__hoverable"))
                .click();
        return new WorkSpacesSettings();
    }

    /**
     * Work space name error.
     *
     * @param errorMessage is the message.
     * @return true or false.
     */
    public boolean verifyWorkSpaceBankNameError(final String errorMessage) {
        return CommonActions
                .verifyMessages(worksapaceCantBeBlankMessage, errorMessage);
    }

    /**
     * Get the error message.
     *
     * @return the text of the message.
     */
    public String getWorkSpaceBlankNameError() {
        return worksapaceCantBeBlankMessage.getText();

    }

    /**
     * Get the error message.
     *
     * @return the text of the message.
     */
    public String getWorkspaceTakenNameMessage() {
        return workspaceNameisTakenMessage.getText();
    }

    /**
     * This method verify the message of worksapage name.
     *
     * @param errorMessage is the message.
     * @return true if the message is correct or false if not.
     */
    public boolean verifySameNameWorkspaceName(final String errorMessage) {
        return CommonActions.verifyMessages(errorAboveorBelow, errorMessage);
    }


}
