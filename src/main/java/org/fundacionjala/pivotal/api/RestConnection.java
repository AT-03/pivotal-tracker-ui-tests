package org.fundacionjala.pivotal.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * The class manages the connection to pivotal tracker.
 */
public final class RestConnection {

    private static final String BASE_URI = "baseURI";
    private static final String X_TRACKER_TOKEN_HEADER = "X-TrackerToken";
    private static final Environment ENVIRONMENT = Environment.getInstance();
    private static final String PORT;
    private static final String IP;
    private static final String TOKEN;
    private static RestConnection instance;

    static {
        PORT = ENVIRONMENT.getEnv("proxyPort");
        IP = ENVIRONMENT.getEnv("proxyIp");
        TOKEN = ENVIRONMENT.getEnv("apiToken");
    }

    private RequestSpecification requestSpecification;

    /**
     * The constructor constructs an specific request, using all the next
     * common parameters: proxy, header and baseUri.
     */
    private RestConnection() {
        RestAssured.baseURI = ENVIRONMENT.getEnv(BASE_URI);

        requestSpecification = new RequestSpecBuilder()
                .addHeader(X_TRACKER_TOKEN_HEADER, TOKEN)
                .setRelaxedHTTPSValidation().build();

        if (!IP.isEmpty() && !PORT.isEmpty()) {
            requestSpecification.proxy(IP, Integer.parseInt(PORT));
        }
    }

    /**
     * @return the RestConnection instance.
     */
    public static RestConnection getInstance() {
        if (instance == null) {
            instance = new RestConnection();
        }
        return instance;
    }

    /**
     * @return a request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
