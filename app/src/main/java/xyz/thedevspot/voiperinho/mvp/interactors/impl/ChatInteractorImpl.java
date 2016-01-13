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

    private ChatListener listener;

    @Override
    public void sendMessage(ChatListener listener, Message message) {
        this.listener = listener;

        ReceiverSocket.getInstance().setChatListener(chatSocketListener);

        new Thread(new SenderSocket(ReceiverSocket.getInstance().getClient(), message, chatSocketListener)).start();
    }

    private ChatListener chatSocketListener = new ChatListener() {
        @Override
        public void onMessageSuccess(Message message) {
            listener.onMessageSuccess(message);
        }

        @Override
        public void onMessageFail() {
            listener.onMessageFail();
        }
    };
}
