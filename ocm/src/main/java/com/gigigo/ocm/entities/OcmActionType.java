package com.gigigo.ocm.entities;

/**
 * Created by rui.alonso on 19/10/16.
 */

public enum OcmActionType {
  GO_CONTENT("GO_CONTENT"),
  ARTICLE("ARTICLE"),
  IMAGE("IMAGE"),
  VIDEO("VIDEO"),
  WEBVIEW("WEBVIEW");

  private String text;

  OcmActionType(String text) {
    this.text = text;
  }

  public static OcmActionType fromString(String text) {
    if(text != null) {
      for(OcmActionType actionType : OcmActionType.values()) {
        if(text.equalsIgnoreCase(actionType.text)) return actionType;
      }
    }
    return null;
  }
}
