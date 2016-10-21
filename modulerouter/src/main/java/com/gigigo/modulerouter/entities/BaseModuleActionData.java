package com.gigigo.modulerouter.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.gigigo.modulerouter.router.Message;

/**
 * Created by rui.alonso on 19/10/16.
 */

public class BaseModuleActionData extends Message implements Parcelable {

  public static final Creator<BaseModuleActionData> CREATOR = new Creator<BaseModuleActionData>() {
    @Override public BaseModuleActionData createFromParcel(Parcel in) {
      return new BaseModuleActionData(in);
    }

    @Override public BaseModuleActionData[] newArray(int size) {
      return new BaseModuleActionData[size];
    }
  };
  protected String moduleName;
  private String actionType;
  private String url;

  public BaseModuleActionData() {

  }

  protected BaseModuleActionData(Parcel in) {
    moduleName = in.readString();
    actionType = in.readString();
    url = in.readString();
  }

  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  public String getActionType() {
    return actionType;
  }

  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(moduleName);
    dest.writeString(actionType);
    dest.writeString(url);
  }
}
