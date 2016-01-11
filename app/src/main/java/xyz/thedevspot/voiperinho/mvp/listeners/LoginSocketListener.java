package xyz.thedevspot.voiperinho.mvp.listeners;

import java.net.Socket;

import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 11/01/16.
 */
public interface LoginSocketListener {

    void onLoginSuccess(User user);

    void onLoginFail();

    void onConnectionSuccess(Socket client);

    void onConnectionFail();
}
