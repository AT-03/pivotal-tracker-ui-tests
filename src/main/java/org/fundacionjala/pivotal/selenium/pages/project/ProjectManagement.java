package org.fundacionjala.pivotal.selenium.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.selenium.pages.common.CommonActions;

/**
 * This Class is Project Management.
 */
public class ProjectManagement extends AbstractBasePage {

    @FindBy(css = "span.raw_context_name")
    private WebElement projectNameSpan;

    /**
     * this project obtain project name.
     *
     * @return project name.
     */
    public String getProjectName() {
        return CommonActions.getText(projectNameSpan);
    }

}
