package com.gigigo.modulerouter;

import com.gigigo.router.Message;
import com.gigigo.router.Receiver;

/**
 * Created by rui.alonso on 19/10/16.
 * AbstractFactory - AbstractFactory
 */
public interface ModuleFactory<T, M extends Message> extends Receiver<M> {
  String getModuleName();

  boolean findAction(String action);

  void requestForExecute(T actionData);
}
