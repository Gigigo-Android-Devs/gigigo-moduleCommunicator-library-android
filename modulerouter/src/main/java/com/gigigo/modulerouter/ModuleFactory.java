package com.gigigo.modulerouter;

import com.gigigo.modulerouter.router.ModuleRouter;
import com.gigigo.router.Message;
import com.gigigo.router.Receiver;

/**
 * Created by rui.alonso on 19/10/16.
 * AbstractFactory - AbstractFactory
 */
public abstract class ModuleFactory<T, M extends Message> implements Receiver<M> {
  protected ModuleRouter moduleRouter;

  public ModuleFactory() {
    initRouter();
  }

  public void initRouter() {
    this.moduleRouter = ModuleRouter.newInstance();
    this.moduleRouter.addModule(this);
  }

  public abstract String getModuleName();

  public abstract boolean findAction(String action);

  public abstract void requestForExecute(T actionData);

  @Override public abstract void receiveMessage(M message);
}
