package xyz.thedevspot.voiperinho.mvp.views;

import java.util.List;

import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 10/01/16.
 */
public interface RequestsView extends BaseView {

    void onRequestsReceived(List<User> requestList);

    void onRequestsEmpty();
}
