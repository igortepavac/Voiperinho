package xyz.thedevspot.voiperinho.mvp.interactors;

import java.util.List;

import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.listeners.Listener;

/**
 * Created by foi on 09/01/16.
 */
public interface ContactsInteractor {

    void getContacts(Listener<List<User>> listener);
}
