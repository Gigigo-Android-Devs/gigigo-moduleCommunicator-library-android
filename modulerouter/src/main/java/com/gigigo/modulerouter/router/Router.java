package com.gigigo.modulerouter.router;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by rui.alonso on 20/10/16.
 */

public abstract class Router<T, M extends Message> implements Sender<M> {
  private Map<String, T> routes;

  public Router() {
    routes = new HashMap<>();
  }

  public boolean addRoute(String key, T route) {
    boolean added = false;
    if (!routes.containsKey(key)) {
      routes.put(key, route);
      added = true;
    }
    return added;
  }

  public T getRoute(String key) {
    return routes.get(key);
  }

  public Iterator<String> getRoutesIterator() {
    return routes.keySet().iterator();
  }

  public boolean removeRoute(String key) {
    boolean removed = false;
    if (routes.containsKey(key)) {
      routes.remove(key);
      removed = true;
    }
    return removed;
  }

  public boolean hasRoute(String key) {
    return routes.containsKey(key);
  }

  @Override public synchronized void sendMessage(M message) {
    new RouterThread(this, message);
  }

  public abstract void run(M message);

  private class RouterThread implements Runnable {
    private final WeakReference<Router> router;
    private M message;
    private Thread runner;

    public RouterThread(Router router, M message) {
      this.router = new WeakReference<>(router);
      this.message = message;
      runner = new Thread(this);
      runner.start();
    }

    @Override public void run() {
      Router router = this.router.get();
      if (router != null) {
        router.run(message);
      }
    }
  }
}
