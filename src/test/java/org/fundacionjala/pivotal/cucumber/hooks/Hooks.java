package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.fundacionjala.pivotal.cucumber.api.RequestManager;
import org.fundacionjala.pivotal.cucumber.utils.StoreVariables;
import org.fundacionjala.pivotal.cucumber.utils.Utils;

import static org.fundacionjala.pivotal.cucumber.api.RequestManager.delete;


/**
 * Created by Ruber Cuellar on 6/7/2017.
 */
public class Hooks {

    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String ID_KEY = "id";

    /**
     * Constructor.
     */
    public Hooks() {
    }

    /**
     * To delete a project.
     */
    @After("@deleteProject")
    public void setup() {
        Iterator<StoreVariables> iter = Utils.getStoreVariables().iterator();
        while (iter.hasNext()) {
            StoreVariables variable = iter.next();
            if (variable.getName().contains("Project")) {
                delete(Utils.buildEndpoint(String.format("/projects/[%s.id]", variable.getName())));
                iter.remove();
            }
        }
    }

    /**
     * To delete a project.
     */
    @Before()
    public void clearValues() {
        Utils.getStoreVariables().removeAll(Utils.getStoreVariables());
    }

    /**
     * To delete workspaces.
     */
    @After("@deleteWorkspace")
    public void resetworkspace() {
        Iterator<StoreVariables> iter = Utils.getStoreVariables().iterator();
        while (iter.hasNext()) {
            StoreVariables variable = iter.next();
            if (variable.getName().contains("Workspace")) {
                delete(Utils.buildEndpoint(String.format("/my/workspace/[%s.id]", variable.getName())));
                iter.remove();
            }
        }
    }


    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteAllProjects")
    public final void deleteAllProjects() {
        List<Map<String, ?>> projects = RequestManager.get(PROJECTS_ENDPOINT).jsonPath().get();
        for (Map<String, ?> object : projects) {
            delete(PROJECTS_ENDPOINT + object.get(ID_KEY).toString());
        }
    }
}
