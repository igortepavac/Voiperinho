package xyz.thedevspot.voiperinho.mvp.listeners;

import java.net.Socket;

/**
 * Created by foi on 11/01/16.
 */
public interface LoginSocketListener {

    void onLoginSuccess(int id);

    void onLoginFail();

    void onConnectionSuccess(Socket client);

    void onConnectionFail();
}
