package org.fundacionjala.pivotal.stepdefinitions.api;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.utils.StoreVariables;
import org.fundacionjala.pivotal.utils.Utils;

/**
 * Created by Administrator on 6/1/2017.
 */
public class RequestSteps {

    private Response response;


    /**
     * To send GET request.
     *
     * @param endpoint The endpoint to send
     */
    @When("^I request GET \"([^\"]*)\"$")
    public void iRequestGETWith(final String endpoint) {
        response = RequestManager.get(Utils.buildEndpoint(endpoint));
    }

    /**
     * The method allows to do a POST or PUT request based on the value of
     * the parameter request String.
     *
     * @param request  of String type.
     * @param endpoint of String type.
     * @param body     is a Map.
     */
    @When("^I request \"(POST|PUT)\" \"([^\"]*)\" with:$")
    public void iRequestPOSTWith(final String request, final String endpoint, final Map<String, String> body) {
        String endpoint1 = Utils.buildEndpoint(endpoint);
        response = request.equals("POST") ? RequestManager.post(endpoint1, body)
                : RequestManager.put(endpoint1, body);
    }

    /**
     * To send DELETE request.
     *
     * @param endpoint The endpoint to send.
     */
    @Then("^I request DELETE \"([^\"]*)\"$")
    public void requestDelete(final String endpoint) {
        response = RequestManager.delete(Utils.buildEndpoint(endpoint));
    }

    /**
     * To return response.
     *
     * @return Response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * To store value.
     *
     * @param variableName The variable's name to store
     */
    @And("^I stored as \\[([^\"]*)\\]$")
    public void storeVariable(final String variableName) {
        StoreVariables var = new StoreVariables(variableName, response.jsonPath().get(""));
        Utils.getStoreVariables().add(var);
    }
}
