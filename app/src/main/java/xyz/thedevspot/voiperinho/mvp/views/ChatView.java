package xyz.thedevspot.voiperinho.mvp.views;

import xyz.thedevspot.voiperinho.models.Message;

/**
 * Created by foi on 11/01/16.
 */
public interface ChatView extends BaseView {

    void onMessageReceived(Message message);
}
