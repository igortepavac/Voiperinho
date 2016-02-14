package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.listeners.Listener;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.interactors.ChatInteractor;
import xyz.thedevspot.voiperinho.network.callbacks.ChatCallback;
import xyz.thedevspot.voiperinho.network.socket.ReceiverSocket;
import xyz.thedevspot.voiperinho.network.socket.SenderSocket;

/**
 * Created by foi on 13/01/16.
 */
public class ChatInteractorImpl implements ChatInteractor {

    private Listener<Message> listener;

    @Override
    public void sendMessage(Listener<Message> listener, Message message) {
        this.listener = listener;
        ReceiverSocket.getInstance().setChatCallback(callback);
        new Thread(new SenderSocket(ReceiverSocket.getInstance().getClient(), message)).start();
    }

    private ChatCallback callback = new xyz.thedevspot.voiperinho.network.callbacks.ChatCallback() {
        @Override
        public void onMessageReceived(Message message) {
            listener.onSuccess(message);
        }
    };
}
