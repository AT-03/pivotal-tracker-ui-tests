package org.fundacionjala.pivotal.cucumber.selenium.pages.project;

/**
 * Created by Administrator on 6/14/2017.
 */
public enum ProjectPrivacy {
    PRIVATE,
    PUBLIC;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
