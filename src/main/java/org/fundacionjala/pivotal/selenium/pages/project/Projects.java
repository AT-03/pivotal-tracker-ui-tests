package org.fundacionjala.pivotal.selenium.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.selenium.pages.AbstractBasePage;

/**
 * Created by Administrator on 6/14/2017.
 */
public class Projects extends AbstractBasePage {

    /**
     * Locate stories label.
     */
    @FindBy(css = "header.tc_page_header nav a[data-aid='navTab-stories']")
    @CacheLookup
    private WebElement storiesLabel;

    /**
     * Locate analytics label.
     */
    @FindBy(css = "header.tc_page_header nav a[data-aid='navTab-analytics']")
    @CacheLookup
    private WebElement analyticsLabel;

    /**
     * Locate element.
     */
    @FindBy(css = "header.tc_page_header nav a[data-aid='navTab-settings']")
    @CacheLookup
    private WebElement settingsLabel;

    /**
     * Locate element.
     */
    @FindBy(css = "header.tc_page_header nav a[data-aid='navTab-members']")
    @CacheLookup
    private WebElement membersLabel;

}
