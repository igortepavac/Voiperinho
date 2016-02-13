package xyz.thedevspot.voiperinho.mvp.interactors;

import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.listeners.Listener;

/**
 * Created by foi on 13/01/16.
 */
public interface ChatInteractor {

    void sendMessage(Listener<Message> listener, Message message);
}
