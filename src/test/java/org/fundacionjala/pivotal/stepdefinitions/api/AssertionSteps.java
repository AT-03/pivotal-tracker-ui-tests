package org.fundacionjala.pivotal.stepdefinitions.api;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Ruber Cuellar on 6/2/2017.
 */
public class AssertionSteps {

    private RequestSteps steps;

    /**
     * Constructor.
     *
     * @param steps RequestSteps to get response
     */
    public AssertionSteps(final RequestSteps steps) {
        this.steps = steps;
    }

    /**
     * To get expect status code.
     *
     * @param statusCode The endpoint to send
     */
    @Then("^I expect status code (\\d+)$")
    public void expectedStatus(final int statusCode) {
        assertEquals(statusCode, steps.getResponse().getStatusCode());
    }

    /**
     * To verify a specific value in response.
     *
     * @param key   The key to verify
     * @param value The value expected
     */
    @And("^the \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void theShouldBe(final String key, final String value) {
        assertEquals(steps.getResponse().jsonPath().get(key).toString(), value);
    }

    /**
     * To verify empty array.
     */
    @And("^the response array should be empty$")
    public void theResponseArrayShouldBeEmpty() {
        assertEquals(steps.getResponse().getBody().jsonPath().get("results").toString(), "[]");
    }

    /**
     * The method verifies the array response is not empty.
     */
    @And("^The response array should not be empty")
    public void theResponseArrayShouldContainAtLeastOneAccount() {
        List accounts = steps.getResponse().jsonPath().get();
        assertFalse(accounts.isEmpty());
    }
}
