package com.gigigo.ocm.executor;

import android.content.Context;
import com.gigigo.entities.BaseModuleActionData;

/**
 * Created by rui.alonso on 19/10/16.
 */
public class OcmModuleActionExecutor {
  public static OcmModuleActionExecutor instance;
  private Context context;

  private OcmModuleActionExecutor(Context context) {
    this.context = context;
  }

  public static OcmModuleActionExecutor newInstance(Context context) {
    if (instance == null) instance = new OcmModuleActionExecutor(context);
    return instance;
  }

  public void executeAction(BaseModuleActionData actionData) {

  }
}
