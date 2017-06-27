package org.fundacionjala.pivotal.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ruber Cuellar on 6/8/2017.
 */
public final class Utils {

    private static final String BY_POINT = "\\.";
    private static final List<StoreVariables> STORE_VARIABLES = new ArrayList<StoreVariables>();
    private static final String REGEX_INSIDE_BRACKETS = "(?<=\\[)(.*?)(?=\\])";
    private static final String REGEX_BRACKETS = "[\\[\\]]";
    private static final int LIMIT = 2;
    private static final int KEY = 1;
    private static final int VALUE = 0;

    /**
     * Constructor.
     */
    private Utils() {
    }

    /**
     * To return store variables.
     *
     * @return List<StorageVariables>
     */
    public static List<StoreVariables> getStoreVariables() {
        return STORE_VARIABLES;
    }


    /**
     * To get specific value and key from list.
     *
     * @param varName The object's name
     * @param key     The object's key
     * @return String
     */
    public static String getKeyObjectFromListByName(final String varName, final String key) {
        for (StoreVariables var : STORE_VARIABLES) {
            if (var.getName().equals(varName)) {
                return var.getAttribute(key);
            }
        }
        return "";
    }

    /**
     * To build endpoint.
     *
     * @param endpoint The endpoint to build
     * @return String
     */
    public static String buildEndpoint(final String endpoint) {
        if (endpoint.isEmpty()) {
            return "";
        }
        Matcher matches = Pattern.compile(REGEX_INSIDE_BRACKETS).matcher(endpoint);
        StringBuffer newEndPoint = new StringBuffer();
        while (matches.find()) {
            String[] parametersParts = matches.group().split(BY_POINT, LIMIT);
            String replaceParameter = getKeyObjectFromListByName(parametersParts[VALUE],
                    parametersParts[KEY]);
            matches.appendReplacement(newEndPoint, replaceParameter);
        }
        matches.appendTail(newEndPoint);
        return newEndPoint.toString().replaceAll(REGEX_BRACKETS, "");
    }

}
