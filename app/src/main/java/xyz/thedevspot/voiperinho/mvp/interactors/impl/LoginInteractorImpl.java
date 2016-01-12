package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import android.os.Handler;
import android.os.Looper;

import java.net.Socket;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.helpers.SocketHelper;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginSocketListener;
import xyz.thedevspot.voiperinho.network.ReceiverSocket;

/**
 * Created by foi on 06/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener listener;

    private Handler handler;

    @Override
    public void attemptLogin(LoginListener listener, String username, String password) {
        this.listener = listener;
        this.handler = new Handler(Looper.getMainLooper());

        new Thread(new SocketHelper(handler, loginSocketListener, username, password)).start();
    }

    private LoginSocketListener loginSocketListener = new LoginSocketListener() {

        @Override
        public void onLoginSuccess(User user) {
            SharedPreferencesHelper.setUserId(VoiperinhoApplication.getInstance(), user.getId());
            SharedPreferencesHelper.setUser(VoiperinhoApplication.getInstance(), user.getUsername());
            listener.onLoginSuccess();
        }

        @Override
        public void onLoginFail() {
            listener.onLoginFail();
        }

        @Override
        public void onConnectionSuccess(Socket client) {
            new Thread(new ReceiverSocket(client, handler, loginSocketListener)).start();
        }

        @Override
        public void onConnectionFail() {
            listener.onConnectionError(R.string.connection_error);
        }
    };
}
