package com.gigigo.ox.entities;

/**
 * Created by rui.alonso on 19/10/16.
 */

public enum OxActionType {
  SCAN("SCAN"),
  WEBVIEW("WEBVIEW");

  private String text;

  OxActionType(String text) {
    this.text = text;
  }

  public static OxActionType fromString(String text) {
    if(text != null) {
      for(OxActionType actionType : OxActionType.values()) {
        if(text.equalsIgnoreCase(actionType.text)) return actionType;
      }
    }
    return null;
  }
}
