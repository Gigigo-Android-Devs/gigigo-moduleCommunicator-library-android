package com.gigigo.ox.executor;

import android.content.Context;
import android.content.Intent;
import com.gigigo.ox.entities.OxModuleActionData;

/**
 * Created by rui.alonso on 19/10/16.
 */
public class OxModuleActionExecutor {
  public static final String BROADCAST_ACTION = "OX_ACTION";
  public static final String EXTRA_DATA = "OX_EXTRA_DATA";
  public static OxModuleActionExecutor instance;
  private Context context;

  private OxModuleActionExecutor(Context context) {
    this.context = context;
  }

  public static OxModuleActionExecutor newInstance(Context context) {
    if (instance == null) instance = new OxModuleActionExecutor(context);
    return instance;
  }

  public void executeAction(OxModuleActionData actionData) {
    Intent intent = new Intent();
    intent.putExtra(EXTRA_DATA, actionData);
    intent.setAction(BROADCAST_ACTION);
    context.sendBroadcast(intent);
  }
}
