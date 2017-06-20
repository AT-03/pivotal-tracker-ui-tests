package org.fundacionjala.pivotal.cucumber.selenium.pages.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.fundacionjala.pivotal.cucumber.selenium.pages.AbstractBasePage;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting.ACCOUNT;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting.PROJECT_PRIVACY;

/**
 * Created by Administrator on 6/14/2017.
 */
public class ProjectForm extends AbstractBasePage {
    @FindBy(css = ".tc-form__input")
    private WebElement projectNameTextField;
    @FindBy(css = ".tc-account-selector__header")
    private WebElement accountDropDownList;

    /**
     * Locate webElement.
     */
    @FindBy(css = ".tc-account-selector__option-account-name")
    private List<WebElement> accountOptionDropDownList;

    /**
     * set work space buuton.
     */

    @FindBy(css = ".tc-form-modal-footer__button."
            + "tc-form-modal-footer__button--submit")
    private WebElement createButton;

    @FindBy(css = "div[data-aid='create-account-button']")
    private WebElement createAccountButtonOptionDropDownList;
    @FindBy(css = "input.tc-account-creator__name")
    private WebElement newAccountProjectTextField;

    /**
     * Click on the Element.
     *
     * @param name is the name of the project.
     */
    public void writeProjectName(final String name) {
        CommonActions.setTextField(projectNameTextField, name);
    }

    /**
     * This method set the Account in the text field or DropDownList.
     *
     * @param account That is to search.
     */
    private void setAccountDropDownList(final String account) {
        CommonActions.clickElement(accountDropDownList);
        List<WebElement> menuBodyList = DriverManager.getInstance()
                .getDriver().findElements(By.xpath("//div[contains(text(), '" + account + "')]"));
        if (menuBodyList.isEmpty()) {
            CommonActions.clickElement(createAccountButtonOptionDropDownList);
            CommonActions.clearTextField(newAccountProjectTextField);
            CommonActions.setTextField(newAccountProjectTextField, account);
        } else {

            final int index = 0;
            CommonActions.clickElement(menuBodyList.get(index));
        }
    }

    /**
     * This method selected privacy project.
     *
     * @param projectPrivacyType return project privacy type.
     */
    private void selectedProjectPrivacy(final ProjectPrivacy projectPrivacyType) {
        WebElement projectPrivacy =
                getWebDriver().findElement(By.cssSelector("input[data-aid='" + projectPrivacyType.toString() + "']"));
        CommonActions.clickElement(projectPrivacy);
    }

    /**
     * Click on the Element.
     *
     * @return the instance of Project class.
     */
    public Projects clickOnCreateAccountButton() {
        CommonActions.clickElement(createButton);
        return new Projects();
    }

    /**
     * Executes the configurations sent.
     *
     * @param configureMap is a map that contains the configurations.
     */
    public void setConfiguration(final Map<ProjectFormSetting, String> configureMap) {
        Map<ProjectFormSetting, ProjectFormStep> strategyOption = strategyConfigureSetting(configureMap);
        Set<ProjectFormSetting> keys = configureMap.keySet();
        for (ProjectFormSetting key : keys) {
            strategyOption.get(key).executeStep();
        }
    }

    /**
     * Create an strategy steps configuration options filling a map with
     * all the existing configurations.
     *
     * @param configureMap is a map that contains all the configurations.
     * @return the configure map with strategies.
     */
    private Map<ProjectFormSetting, ProjectFormStep> strategyConfigureSetting(
            final Map<ProjectFormSetting, String> configureMap) {
        Map<ProjectFormSetting, ProjectFormStep> strategyMap = new HashMap<>();
        strategyMap.put(PROJECT_NAME, () -> writeProjectName(configureMap.get(PROJECT_NAME)));
        strategyMap.put(ACCOUNT, () -> setAccountDropDownList(configureMap.get(ACCOUNT)));
        strategyMap.put(PROJECT_PRIVACY, () -> selectedProjectPrivacy(ProjectPrivacy
                .valueOf(configureMap.get(PROJECT_PRIVACY).toUpperCase())));
        return strategyMap;
    }

}
