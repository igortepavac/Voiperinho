package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.helpers.MessageType;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.interactors.ChatInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.ChatListener;
import xyz.thedevspot.voiperinho.mvp.presenters.ChatPresenter;
import xyz.thedevspot.voiperinho.mvp.views.ChatView;

/**
 * Created by foi on 13/01/16.
 */
public class ChatPresenterImpl implements ChatPresenter {

    private ChatView view;

    private ChatInteractor interactor;

    public ChatPresenterImpl(ChatView view, ChatInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void sendMessage(String content) {
        Message message = new Message(content,
                SharedPreferencesHelper.getContact(VoiperinhoApplication.getInstance()),
                SharedPreferencesHelper.getUser(VoiperinhoApplication.getInstance()),
                MessageType.MESSAGE);

        interactor.sendMessage(listener, message);
    }

    @Override
    public String serializeMessageList(List<Message> messageList) {
        Gson gson = new Gson();
        return gson.toJson(messageList);
    }

    @Override
    public List<Message> deserializeMessageList(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<ArrayList<Message>>(){}.getType());
    }

    private ChatListener listener = new ChatListener() {
        @Override
        public void onMessageSuccess(Message message) {
            view.onMessageSuccess(message);
        }

        @Override
        public void onMessageFail() {
            view.onMessageFail();
        }
    };
}
