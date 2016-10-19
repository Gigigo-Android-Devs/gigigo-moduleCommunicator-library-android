package com.gigigo.ox;

import android.content.Context;
import com.gigigo.ModuleFactory;
import com.gigigo.ModuleRouter;
import com.gigigo.entities.BaseModuleActionData;
import com.gigigo.ox.entities.OxActionType;
import com.gigigo.ox.entities.OxModuleActionData;
import com.gigigo.ox.executor.OxModuleActionExecutor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui.alonso on 19/10/16.
 * AbstractFactory - ConcreteFactory
 */
public class OxModuleFactory implements ModuleFactory<OxModuleActionData> {
  public static OxModuleFactory instance;
  public static String MODULE_NAME = "ORCHEXTRA_MODULE";

  private ModuleRouter moduleRouter;
  private OxModuleActionExecutor oxModuleActionExecutor;
  //private Map<String, ActionFactory> actionFactoryMap;
  private List<OxActionType> actionTypes;

  private OxModuleFactory(Context context) {
    initModule(context);
    setActions();
  }

  public static OxModuleFactory newInstance(Context context) {
    if (instance == null) instance = new OxModuleFactory(context);
    return instance;
  }

  private void initModule(Context context) {
    this.moduleRouter = ModuleRouter.newInstance();
    this.moduleRouter.addModule(this);
    this.oxModuleActionExecutor = OxModuleActionExecutor.newInstance(context);
  }

  private void setActions() {
    //actionFactoryMap = new HashMap<>();
    actionTypes = new ArrayList<>();
    /*
    actionTypes.add(OxActionType.SCAN);
    actionTypes.add(OxActionType.WEBVIEW);*/
  }

  @Override public String getModuleName() {
    return MODULE_NAME;
  }

  @Override public boolean findAction(String actionType) {
    //return actionFactoryMap.containsKey(actionType);
    OxActionType oxActionType = OxActionType.fromString(actionType);
    return actionTypes.contains(oxActionType);
  }

  @Override public void execute(BaseModuleActionData actionData) {
    //TODO: parse from BaseModuleActionData to OxModuleActionData
    oxModuleActionExecutor.executeAction(actionData);
  }

  @Override public void requestForExecute(OxModuleActionData actionData) {
    //TODO: parse from OxModuleActionData to BaseModuleActionData
    moduleRouter.route(actionData);
  }
}
