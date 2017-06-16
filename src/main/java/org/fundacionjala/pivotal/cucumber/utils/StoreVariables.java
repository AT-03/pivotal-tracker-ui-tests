package org.fundacionjala.pivotal.cucumber.utils;

import java.util.Map;

/**
 * Created by Ruber Cuellar on 6/6/2017.
 */
public class StoreVariables {
    private String name;
    private Map<String, ?> values;

    /**
     * Constructor.
     * @param name The name of variable
     * @param values The variable's values
     */
    public StoreVariables(final String name, final Map<String, ?> values) {
        this.name = name;
        this.values = values;
    }

    /**
     * To get values from object.
     * @return Map<Map, ?>
     */
    public Map<String, ?> getValues() {
        return values;
    }

    /**
     * Get specific key/attribute from map.
     * @param key The key to get.
     * @return String
     */
    public String getAttribute(final String key) {
        return values.get(key).toString();
    }

    /**
     * To return the object's name.
     * @return String
     */
    public String getName() {
        return name;
    }
}
