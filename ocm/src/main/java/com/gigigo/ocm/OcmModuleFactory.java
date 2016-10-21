package com.gigigo.ocm;

import android.content.Context;
import com.gigigo.modulerouter.ModuleFactory;
import com.gigigo.modulerouter.ModuleRouter;
import com.gigigo.modulerouter.entities.BaseModuleActionData;
import com.gigigo.ocm.entities.OcmActionType;
import com.gigigo.ocm.entities.OcmModuleActionData;
import com.gigigo.ocm.executor.OcmModuleActionExecutor;
import com.gigigo.ocm.mappers.OcmActionDataMapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui.alonso on 19/10/16.
 * AbstractFactory - ConcreteFactory
 */
public class OcmModuleFactory implements ModuleFactory<OcmModuleActionData, BaseModuleActionData> {
  public static OcmModuleFactory instance;
  public static String MODULE_NAME = "ORCHEXTRA_CONTENT_MANAGER_MODULE";

  private ModuleRouter moduleRouter;
  private OcmModuleActionExecutor ocmModuleActionExecutor;
  //private Map<String, ActionFactory> actionFactoryMap;
  private List<OcmActionType> actionTypes;
  private OcmActionDataMapper ocmActionDataMapper;

  private OcmModuleFactory(Context context) {
    initModule(context);
    setActions();
  }

  public static OcmModuleFactory newInstance(Context context) {
    if (instance == null) instance = new OcmModuleFactory(context);
    return instance;
  }

  private void initModule(Context context) {
    this.moduleRouter = ModuleRouter.newInstance();
    this.moduleRouter.addModule(this);
    this.ocmModuleActionExecutor = OcmModuleActionExecutor.newInstance(context);
    this.ocmActionDataMapper = new OcmActionDataMapper();
  }

  private void setActions() {
    //actionFactoryMap = new HashMap<>();
    actionTypes = new ArrayList<>();
    actionTypes.add(OcmActionType.GO_CONTENT);
    actionTypes.add(OcmActionType.ARTICLE);
    actionTypes.add(OcmActionType.IMAGE);
    actionTypes.add(OcmActionType.VIDEO);
    actionTypes.add(OcmActionType.WEBVIEW);
  }

  @Override public String getModuleName() {
    return MODULE_NAME;
  }

  @Override public boolean findAction(String actionType) {
    //return actionFactoryMap.containsKey(actionType);
    OcmActionType ocmActionType = OcmActionType.fromString(actionType);
    return actionTypes.contains(ocmActionType);
  }


  @Override public void requestForExecute(OcmModuleActionData actionData) {
    BaseModuleActionData baseActionData = ocmActionDataMapper.modelToExternalClass(actionData);
    moduleRouter.sendMessage(baseActionData);
  }

  @Override public void receiveMessage(BaseModuleActionData actionData) {
    OcmModuleActionData ocmActionData = ocmActionDataMapper.externalClassToModel(actionData);
    ocmModuleActionExecutor.executeAction(ocmActionData);
  }
}
