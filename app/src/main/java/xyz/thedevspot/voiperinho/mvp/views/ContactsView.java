package xyz.thedevspot.voiperinho.mvp.views;

import java.util.List;

import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 09/01/16.
 */
public interface ContactsView extends BaseView {

    void onContactsReceived(List<User> contactList);

    void onContatcsEmpty();
}
