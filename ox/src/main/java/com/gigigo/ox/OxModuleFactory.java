package com.gigigo.ox;

import android.content.Context;
import com.gigigo.modulerouter.ModuleFactory;
import com.gigigo.modulerouter.ModuleRouter;
import com.gigigo.modulerouter.entities.BaseModuleActionData;
import com.gigigo.modulerouter.router.Message;
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
public class OxModuleFactory implements ModuleFactory<OxModuleActionData, BaseModuleActionData> {
  public static OxModuleFactory instance;
  public static String MODULE_NAME = "ORCHEXTRA_MODULE";

  private ModuleRouter moduleRouter;
  private OxModuleActionExecutor oxModuleActionExecutor;
  //private Map<String, ActionFactory> actionFactoryMap;
  private List<OxActionType> actionTypes;
  private OxActionDataMapper oxActionDataMapper;

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
    this.oxActionDataMapper = new OxActionDataMapper();
  }

  private void setActions() {
    //actionFactoryMap = new HashMap<>();
    actionTypes = new ArrayList<>();
    actionTypes.add(OxActionType.SCAN);
    actionTypes.add(OxActionType.WEBVIEW);
  }

  @Override public String getModuleName() {
    return MODULE_NAME;
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
