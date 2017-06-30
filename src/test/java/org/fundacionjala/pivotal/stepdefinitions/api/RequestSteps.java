package org.fundacionjala.pivotal.stepdefinitions.api;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.utils.StoreVariables;
import org.fundacionjala.pivotal.utils.Utils;

/**
 * Created by Administrator on 6/1/2017.
 */
public class RequestSteps {

    private static final Logger LOGGER = Logger.getLogger(RequestSteps.class);

    private static final String POST = "POST";

    private static final String ENDPOINT_S = "Endpoint : %s";

    private static final String RESPONSE_S = "Response : %s";

    private Response response;

    /**
     * To send GET request.
     *
     * @param endpoint The endpoint to send
     */
    @When("^I request GET \"([^\"]*)\"$")
    public void iRequestGET(final String endpoint) {
        final String buildEndpoint = Utils.buildEndpoint(endpoint);
        LOGGER.info(String.format(ENDPOINT_S, buildEndpoint));
        response = RequestManager.get(buildEndpoint);
        LOGGER.info(String.format(RESPONSE_S, response.prettyPrint()));
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
        final String buildEndpoint = Utils.buildEndpoint(endpoint);
        LOGGER.info(String.format(ENDPOINT_S, buildEndpoint));
        response = POST.equals(request) ? RequestManager.post(buildEndpoint, body)
                : RequestManager.put(buildEndpoint, body);
        LOGGER.info(String.format(RESPONSE_S, response.prettyPrint()));
    }

    /**
     * To send DELETE request.
     *
     * @param endpoint The endpoint to send.
     */
    @Then("^I request DELETE \"([^\"]*)\"$")
    public void requestDelete(final String endpoint) {
        final String buildEndpoint = Utils.buildEndpoint(endpoint);
        LOGGER.info(String.format(ENDPOINT_S, buildEndpoint));
        response = RequestManager.delete(buildEndpoint);
        LOGGER.info(String.format(RESPONSE_S, response.prettyPrint()));
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

    /**
     * To return response.
     *
     * @return Response
     */
    public Response getResponse() {
        return response;
    }
}
