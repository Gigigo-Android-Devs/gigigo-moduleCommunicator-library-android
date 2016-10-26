package com.gigigo.router;

/**
 * Created by rui.alonso on 20/10/16.
 */

public interface Receiver<M extends Message> {
  void receiveMessage(M message);
}
