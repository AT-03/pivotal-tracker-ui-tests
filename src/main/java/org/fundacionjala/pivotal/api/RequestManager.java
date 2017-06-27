package org.fundacionjala.pivotal.api;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * The RequestManager class contains methods that returns one of the following
 * responses: GET/POST/PUT/DELETE.
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST_SPECIFICATION =
            RestConnection.getInstance().getRequestSpecification();

    /**
     * Private constructor.
     */
    private RequestManager() {
    }

    /**
     * The method returns a GET response.
     *
     * @param endpoint points one specific resource.
     * @return a GET response.
     */
    public static Response get(final String endpoint) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .get(endpoint);
    }

    /**
     * The method returns a POST response.
     *
     * @param endpoint points to one specific resource.
     * @param body     is the body of the request.
     * @return a POST response.
     */
    public static Response post(final String endpoint, final String body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .contentType(ContentType.JSON)
                .body(body)
                .post(endpoint);
    }

    /**
     * The method return a POST response using as parameter a String Map.
     *
     * @param endpoint points to one specific resource.
     * @param body     is the body of the request.
     * @return a POST response.
     */
    public static Response post(final String endpoint, final Map<String, String> body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .params(body)
                .post(endpoint);
    }

    /**
     * The method returns a PUT response.
     *
     * @param endpoint points to one specific resource.
     * @param body     is the body of the request.
     * @return a PUT response.
     */
    public static Response put(final String endpoint, final String body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .contentType(ContentType.JSON)
                .body(body)
                .put(endpoint);
    }

    /**
     * The method returns a PUT response.
     *
     * @param endpoint points to one specific resource.
     * @param body     is the body of the request.
     * @return a PUT response.
     */
    public static Response put(final String endpoint, final Map<String, String> body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .params(body)
                .put(endpoint);
    }

    /**
     * The method returns a DELETE response.
     *
     * @param endpoint point to one specific resource.
     * @return a DELETE response.
     */
    public static Response delete(final String endpoint) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .delete(endpoint);
    }

}
