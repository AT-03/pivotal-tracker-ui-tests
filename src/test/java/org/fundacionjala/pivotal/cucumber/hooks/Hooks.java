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
        for (Iterator<StoreVariables> iter = Utils.getStoreVariables().listIterator(); iter.hasNext();) {
            StoreVariables var = iter.next();
            if (var.getName().contains("Project")) {
                RequestManager.delete(Utils.buildEndpoint("/projects/[" + var.getName() + ".id]"));
                Utils.getStoreVariables().remove(var);
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
    for (StoreVariables var : Utils.getStoreVariables()) {
      if (var.getName().contains("Workspace")) {
        //var.getAttribute("i")
        RequestManager.delete(Utils.buildEndpoint("/my/workspaces/[" + var.getName() + ".id]"));
      }
    }
  }
}
