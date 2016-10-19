package com.gigigo;

import com.gigigo.entities.BaseModuleActionData;

/**
 * Created by rui.alonso on 19/10/16.
 * AbstractFactory - AbstractFactory
 */
public interface ModuleFactory<T> {
  String getModuleName();

  boolean findAction(String action);

  void requestForExecute(T actionData);

  void execute(BaseModuleActionData actionData);
}
