package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import javax.inject.Inject;

import xyz.thedevspot.voiperinho.listeners.Listener;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.interactors.ChatInteractor;
import xyz.thedevspot.voiperinho.network.socket.ReceiverSocket;
import xyz.thedevspot.voiperinho.network.socket.SenderSocket;

/**
 * Created by foi on 13/01/16.
 */
public class ChatInteractorImpl implements ChatInteractor {

    @Inject
    public ChatInteractorImpl() {}

    @Override
    public void sendMessage(Listener<Message> listener, Message message) {
        ReceiverSocket.getInstance().setChatListener(listener);
        new Thread(new SenderSocket(ReceiverSocket.getInstance().getClient(), message)).start();
    }
}
