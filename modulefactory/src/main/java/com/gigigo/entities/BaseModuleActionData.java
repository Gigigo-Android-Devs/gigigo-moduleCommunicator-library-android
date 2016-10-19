package com.gigigo.entities;

/**
 * Created by rui.alonso on 19/10/16.
 */

public class BaseModuleActionData {

  protected String moduleName;
  private String actionType;

  public String getModuleName() {
    return moduleName;
  }

  public String getActionType() {
    return actionType;
  }

  public void setActionType(String actionType) {
    this.actionType = actionType;
  }
}
