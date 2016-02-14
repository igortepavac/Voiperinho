package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import java.net.Socket;

import javax.inject.Inject;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.network.socket.AuthorizationSocket;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.network.callbacks.LoginCallback;
import xyz.thedevspot.voiperinho.listeners.LoginListener;
import xyz.thedevspot.voiperinho.network.socket.ReceiverSocket;

/**
 * Created by foi on 06/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener listener;

    @Inject
    public LoginInteractorImpl() {}

    @Override
    public void attemptLogin(LoginListener listener, String username, String password) {
        this.listener = listener;
        new Thread(new AuthorizationSocket(loginCallback, username, password)).start();
    }

    private LoginCallback loginCallback = new LoginCallback() {

        @Override
        public void onLoginSuccess(User user) {
            SharedPreferencesHelper.setInt(user.getId(), SharedPreferencesHelper.USER_ID);
            SharedPreferencesHelper.setString(user.getUsername(), SharedPreferencesHelper.USER);
            listener.onSuccess(null);
        }

        @Override
        public void onLoginFail() {
            listener.onFailure();
        }

        @Override
        public void onConnectionSuccess(Socket client) {
            new Thread(ReceiverSocket.getInstance(client, loginCallback)).start();
        }

        @Override
        public void onConnectionFail() {
            listener.onConnectionError(R.string.connection_error);
        }
    };
}
