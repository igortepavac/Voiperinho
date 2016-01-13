package xyz.thedevspot.voiperinho.mvp.listeners;

import xyz.thedevspot.voiperinho.models.Message;

/**
 * Created by foi on 13/01/16.
 */
public interface ChatListener {

    void onMessageSuccess(Message message);

    void onMessageFail();
}
