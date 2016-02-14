package xyz.thedevspot.voiperinho.network.callbacks;

import xyz.thedevspot.voiperinho.models.Message;

/**
 * Created by foi on 14/02/16.
 */
public interface ChatCallback {

    void onMessageReceived(Message message);
}
