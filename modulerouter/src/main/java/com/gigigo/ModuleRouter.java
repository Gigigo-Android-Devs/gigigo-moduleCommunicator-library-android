package com.gigigo;

import com.gigigo.entities.BaseModuleActionData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ModuleRouter {
  public static ModuleRouter instance;
  private Map<String, ModuleFactory> moduleReceivers;

  private ModuleRouter() {
    moduleReceivers = new HashMap<>();
  }

  public static ModuleRouter newInstance() {
    if (instance == null) instance = new ModuleRouter();
    return instance;
  }

  public boolean addModule(ModuleFactory module) {
    boolean added = false;
    if (!moduleReceivers.containsKey(module.getModuleName())) {
      moduleReceivers.put(module.getModuleName(), module);
      added = true;
    }
    return added;
  }

  public boolean removeModule(ModuleFactory module) {
    boolean removed = false;
    if (moduleReceivers.containsKey(module.getModuleName())) {
      moduleReceivers.remove(module.getModuleName());
      removed = true;
    }
    return removed;
  }

  public boolean hasModule(ModuleFactory module) {
    return moduleReceivers.containsKey(module.getModuleName());
  }

  public boolean hasModuleName(String moduleName) {
    return moduleReceivers.containsKey(moduleName);
  }

  public synchronized void route(BaseModuleActionData actionData) {
    String moduleName = actionData.getModuleName();
    String action = actionData.getActionType();
    boolean actionFinded = false;

    ModuleFactory module = moduleReceivers.get(moduleName);
    if (module.findAction(action)) {
      module.execute(actionData);
      actionFinded = true;
    }
    else {
      Iterator<String> moduleFactoryIterator = moduleReceivers.keySet().iterator();
      while (moduleFactoryIterator.hasNext()) {
        moduleName = moduleFactoryIterator.next();
        module = moduleReceivers.get(moduleName);

        if (module.findAction(action)) {
          module.execute(actionData);
          actionFinded = true;
        }
      }
    }

    if(!actionFinded) {
      module = moduleReceivers.get(actionData.getModuleName());
      module.execute(actionData);
    }
  }
}
