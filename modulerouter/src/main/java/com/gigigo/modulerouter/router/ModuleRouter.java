package com.gigigo.modulerouter.router;

import com.gigigo.modulerouter.ModuleFactory;
import com.gigigo.router.Router;
import java.util.Iterator;

public class ModuleRouter extends Router<ModuleFactory, BaseModuleActionData> {
  public static ModuleRouter instance;

  public static ModuleRouter newInstance() {
    if (instance == null) instance = new ModuleRouter();
    return instance;
  }

  public boolean addModule(ModuleFactory module) {
    return addRoute(module.getModuleName(), module);
  }

  public boolean removeModule(ModuleFactory module) {
    return removeRoute(module.getModuleName());
  }

  public boolean hasModule(ModuleFactory module) {
    return hasRoute(module.getModuleName());
  }

  public boolean hasModuleName(String moduleName) {
    return hasRoute(moduleName);
  }

  @Override public void run(BaseModuleActionData actionData) {
    String moduleName = actionData.getModuleName();
    String action = actionData.getActionType();
    boolean actionFinded = false;

    ModuleFactory module = getRoute(moduleName);
    if (module.findAction(action)) {
      module.receiveMessage(actionData);
      actionFinded = true;
    } else {
      Iterator<String> moduleFactoryIterator = getRoutesIterator();
      while (moduleFactoryIterator.hasNext()) {
        moduleName = moduleFactoryIterator.next();
        module = getRoute(moduleName);

        if (module.findAction(action)) {
          module.receiveMessage(actionData);
          actionFinded = true;
        }
      }
    }

    if (!actionFinded) {
      module = getRoute(actionData.getModuleName());
      module.receiveMessage(actionData);
    }
  }
}
