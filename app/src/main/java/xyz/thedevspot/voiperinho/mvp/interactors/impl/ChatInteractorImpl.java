package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.interactors.ChatInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.ChatListener;
import xyz.thedevspot.voiperinho.network.ReceiverSocket;
import xyz.thedevspot.voiperinho.network.SenderSocket;

/**
 * Created by foi on 13/01/16.
 */
public class ChatInteractorImpl implements ChatInteractor {

    @Override
    public void sendMessage(ChatListener listener, Message message) {
        ReceiverSocket.getInstance().setChatListener(listener);
        new Thread(new SenderSocket(ReceiverSocket.getInstance().getClient(), message)).start();
    }
}
