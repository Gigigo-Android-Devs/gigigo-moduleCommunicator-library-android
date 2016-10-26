package com.gigigo.router;

/**
 * Created by rui.alonso on 20/10/16.
 */

public interface Sender<M extends Message> {
  void sendMessage(M message);
}
