package xyz.thedevspot.voiperinho.mvp.interactors;

import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.listeners.ChatListener;

/**
 * Created by foi on 13/01/16.
 */
public interface ChatInteractor {

    void sendMessage(ChatListener listener, Message message);
}
