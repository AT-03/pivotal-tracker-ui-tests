package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.util.Iterator;
import org.fundacionjala.pivotal.cucumber.api.RequestManager;
import org.fundacionjala.pivotal.cucumber.utils.StoreVariables;
import org.fundacionjala.pivotal.cucumber.utils.Utils;


/**
 * Created by Ruber Cuellar on 6/7/2017.
 */
public class Hooks {

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
                RequestManager.delete(Utils.buildEndpoint(String.format("/projects/[%s.id]", variable.getName())));
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
              RequestManager.delete(Utils.buildEndpoint(String.format("/my/workspace/[%s.id]", variable.getName())));
              iter.remove();
          }
      }
  }
}
