package org.fundacionjala.pivotal.cucumber.selenium.pages.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    /**
     * this project obtain project id.
     *
     * @return Project id of created new project.
     */
    public String getProjectId() {
        String projectId = "";
        String regularExpression = "(\\d+)$";
        String url = getWebDriver().getCurrentUrl();
        Matcher matcher = Pattern.compile(regularExpression).matcher(url);
        if (matcher.find()) {
            projectId = matcher.group();
        }
        return projectId;
    }
}
