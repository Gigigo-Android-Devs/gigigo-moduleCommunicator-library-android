package com.gigigo.ox.executor;

import android.content.Context;
import com.gigigo.entities.BaseModuleActionData;

/**
 * Created by rui.alonso on 19/10/16.
 */
public class OxModuleActionExecutor {
  public static OxModuleActionExecutor instance;
  private Context context;

  private OxModuleActionExecutor(Context context) {
    this.context = context;
  }

  public static OxModuleActionExecutor newInstance(Context context) {
    if (instance == null) instance = new OxModuleActionExecutor(context);
    return instance;
  }

  public void executeAction(BaseModuleActionData actionData) {

  }
}
