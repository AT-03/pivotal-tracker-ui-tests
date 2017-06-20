package org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.accounts;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.util.Map;
import org.fundacionjala.pivotal.cucumber.selenium.pages.common.Navegator;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectManagement;
import org.fundacionjala.pivotal.cucumber.stepdefinitions.ui.commonsteps.CommonStepsUI;


import static org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting.ACCOUNT;
import static org.fundacionjala.pivotal.cucumber.selenium.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by reinaldo on 20/06/2017.
 */
public class AccountAssertionUI {

    private Map<ProjectFormSetting, String> settingMap;

    /**
     * Constructor where initialize the values.
     *
     * @param accountStepsUI ResourcesStep.
     */
    public AccountAssertionUI(final AccountStepsUI accountStepsUI) {

        settingMap = accountStepsUI.getSettingMap();
    }

    /**
     * this method verify that a new project is created.
     */
    @Then("Verify that a new project is created")
    public void verifyThatANewProjectIsCreated() {
        ProjectManagement projectManagement = new ProjectManagement();
        final String expected = projectManagement.getProjectName();
        final String actual = settingMap.get(PROJECT_NAME);
        assertEquals(expected, actual);
    }

    /**
     * The method verify a account with his account.
     */
    @And("^Verify the new account with his project$")
    public void verifyTheNewAccountWithHisProject() {
        Navegator.goToDashboard();
        final String itemAccount = settingMap.get(ACCOUNT);
        boolean resultActual = CommonStepsUI.getAccount().
                findAccount(CommonStepsUI.getAccount().getNameAccountList(), itemAccount);
        assertTrue(resultActual);

    }
}
