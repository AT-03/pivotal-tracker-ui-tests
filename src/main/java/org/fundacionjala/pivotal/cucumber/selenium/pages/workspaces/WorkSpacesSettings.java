package org.fundacionjala.pivotal.cucumber.selenium.pages.workspaces;

import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 6/16/2017.
 */
public class WorkSpacesSettings extends AbstractBasePage {
    /**
     * Locator.
     */
    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement pivotalLogo;

    /**
     * Locator.
     */
    @FindBy(css = "input.save_bar__submit")
    private WebElement saveButton;

    /**
     * Locator.
     */
    @FindBy(css = "#workspace_name")
    private WebElement workSpaceNameField;

    /**
     * Locator.
     */
    @FindBy(css = "div[id='save_success_bar'] div.message")
    private WebElement saveChangesMessage;

    /**
     * Locator.
     */
    @FindBy(css = "div.tc_header_project_name")
    private WebElement heraderWorkSpace;
    /**
     * Locator.
     */
    @FindBy(id = "delete_link")
    private WebElement deleteLink;
    /**
     * Locator.
     */
    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteButton;

    /**
     * Locator.
     */
    @FindBy(css = "a.cancel")
    private WebElement cancelDeleteButton;

    /**
     * Update worksapace name.
     *
     * @param newName is the new name of the workspac.
     */
    public void updateWorkSpaceName(final String newName) {
        CommonActions.setTextField(workSpaceNameField, newName);
    }

    /**
     * Clik on save button to save the changes.
     */
    public void clickOnSaveButton() {
        CommonActions.clickElement(saveButton);
    }

    /**
     * Verify message.
     *
     * @param message is the message.
     * @return true if the expected message is equals to displayed message.
     */
    public boolean verifyChangesSavedMessage(final String message) {
        return CommonActions.verifyMessages(saveChangesMessage, message);
    }

    /**
     * verify the name of the worksapace.
     *
     * @param workspaceName is the name of the workspace
     * @return true if the name matches or false if not.
     */

    public boolean verifyWorkspaceName(final String workspaceName) {
        DriverManager.getInstance().getWait()
                .until(ExpectedConditions.visibilityOf(saveChangesMessage));
        return CommonActions.verifyMessages(heraderWorkSpace, workspaceName);
    }

    /**
     * Click on pivotal tracker logo to go back to the dashboard.
     */
    public void gotoDashBoard() {
        CommonActions.clickElement(pivotalLogo);
    }

    /**
     * Click on delete button.
     */
    public void clickOnDeleteLink() {
        CommonActions.clickOnaHiddenElement(deleteLink);
    }

    /**
     * Click on confirm delete button.
     */
    public void clickOnConfirmDeleteButton() {
        CommonActions.clickElement(confirmDeleteButton);
    }

    /**
     * click on cancel deletion button.
     */
    public void clickOnCancelDeletionButton() {
        CommonActions.clickElement(cancelDeleteButton);
    }

}
