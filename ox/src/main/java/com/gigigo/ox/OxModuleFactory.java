package com.gigigo.ox;

import android.content.Context;
import com.gigigo.modulerouter.ModuleFactory;
import com.gigigo.modulerouter.router.BaseModuleActionData;
import com.gigigo.ox.entities.OxActionType;
import com.gigigo.ox.entities.OxModuleActionData;
import com.gigigo.ox.executor.OxModuleActionExecutor;
import com.gigigo.ox.mappers.OxActionDataMapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui.alonso on 19/10/16.
 * AbstractFactory - ConcreteFactory
 */
public class OxModuleFactory extends ModuleFactory<OxModuleActionData,BaseModuleActionData> {
  public static OxModuleFactory instance;
  private static String MODULE_NAME = "ORCHEXTRA_MODULE";

  private OxModuleActionExecutor oxModuleActionExecutor;
  //private Map<String, ActionFactory> actionFactoryMap;
  private List<OxActionType> actionTypes;
  private OxActionDataMapper oxActionDataMapper;

  private OxModuleFactory(Context context) {
    this.oxModuleActionExecutor = OxModuleActionExecutor.newInstance(context);
    this.oxActionDataMapper = new OxActionDataMapper();
    setActions();
  }

  public static OxModuleFactory newInstance(Context context) {
    if (instance == null) instance = new OxModuleFactory(context);
    return instance;
  }

  @Override public String getModuleName() {
    return MODULE_NAME;
  }

  private void setActions() {
    //actionFactoryMap = new HashMap<>();
    actionTypes = new ArrayList<>();
    actionTypes.add(OxActionType.SCAN);
    actionTypes.add(OxActionType.WEBVIEW);
  }

  @Override public boolean findAction(String actionType) {
    //return actionFactoryMap.containsKey(actionType);
    OxActionType oxActionType = OxActionType.fromString(actionType);
    return actionTypes.contains(oxActionType);
  }

  @Override public void requestForExecute(OxModuleActionData actionData) {
    BaseModuleActionData baseActionData = oxActionDataMapper.modelToExternalClass(actionData);
    moduleRouter.sendMessage(baseActionData);
  }

  @Override public void receiveMessage(BaseModuleActionData actionData) {
    OxModuleActionData oxActionData = oxActionDataMapper.externalClassToModel(actionData);
    oxModuleActionExecutor.executeAction(oxActionData);
  }
}
