package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import android.os.Handler;
import android.os.Looper;

import java.net.Socket;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.helpers.SocketHelper;
import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginSocketListener;
import xyz.thedevspot.voiperinho.network.RecieverSocket;

/**
 * Created by foi on 06/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener listener;

    private Handler handler;

    @Override
    public void attemptLogin(LoginListener listener, String username, String password) {
        this.listener = listener;

        handler = new Handler(Looper.getMainLooper());
        //handler.post(new SocketHelper(handler, loginResponseListener, username, password));

        SocketHelper socketHelper = new SocketHelper(handler, loginSocketListener, username, password);
        Thread t = new Thread(socketHelper);
        t.start();
    }

    private LoginSocketListener loginSocketListener = new LoginSocketListener() {
        @Override
        public void onLoginSuccess(int id) {
            listener.onLoginSuccess();
        }

        @Override
        public void onLoginFail() {
            listener.onLoginFail();
        }

        @Override
        public void onConnectionSuccess(Socket client) {
            new Thread(new RecieverSocket(client, handler, loginSocketListener, false)).start();
        }

        @Override
        public void onConnectionFail() {
            listener.onConnectionError(R.string.connection_error);
        }
    };
}
