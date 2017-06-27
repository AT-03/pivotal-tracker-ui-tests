package org.fundacionjala.pivotal.hooks.api;

import java.util.List;
import java.util.Map;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.utils.Utils;


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
        Utils.getStoreVariables().stream()
                .filter(element -> element.getName().contains("Project"))
                .forEach(project -> {
                    final String format = String.format("/projects/[%s.id]", project.getName());
                    RequestManager.delete(Utils.buildEndpoint(format));
                });
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
        Utils.getStoreVariables().stream()
                .filter(element -> element.getName().contains("Workspace"))
                .forEach(workspace -> {
                    final String format = String.format("/my/workspaces/[%s.id]", workspace.getName());
                    RequestManager.delete(Utils.buildEndpoint(format));
                });
    }


    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteAllProjects")
    public final void deleteAllProjects() {
        List<Map<String, ?>> projects = RequestManager.get(PROJECTS_ENDPOINT).jsonPath().get();
        for (Map<String, ?> object : projects) {
            RequestManager.delete(PROJECTS_ENDPOINT + object.get(ID_KEY).toString());
        }
    }
}
