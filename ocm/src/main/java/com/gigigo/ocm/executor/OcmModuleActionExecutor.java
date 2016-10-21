package com.gigigo.ocm.executor;

import android.content.Context;
import android.content.Intent;
import com.gigigo.ocm.entities.OcmModuleActionData;

/**
 * Created by rui.alonso on 19/10/16.
 */
public class OcmModuleActionExecutor {
  public static final String BROADCAST_ACTION = "OCM_ACTION";
  public static final String EXTRA_DATA = "OCM_EXTRA_DATA";
  public static OcmModuleActionExecutor instance;
  private Context context;

  private OcmModuleActionExecutor(Context context) {
    this.context = context;
  }

  public static OcmModuleActionExecutor newInstance(Context context) {
    if (instance == null) instance = new OcmModuleActionExecutor(context);
    return instance;
  }

  public void executeAction(OcmModuleActionData actionData) {
    Intent intent = new Intent();
    intent.putExtra(EXTRA_DATA, actionData);
    intent.setAction(BROADCAST_ACTION);
    context.sendBroadcast(intent);
  }
}
