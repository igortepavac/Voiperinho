package xyz.thedevspot.voiperinho.mvp.presenters;

import java.util.List;

import xyz.thedevspot.voiperinho.models.Message;

/**
 * Created by foi on 13/01/16.
 */
public interface ChatPresenter {

    void sendMessage(String content);

    String serializeMessageList(List<Message> messageList);

    List<Message> deserializeMessageList(String json);
}
