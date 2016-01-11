package xyz.thedevspot.voiperinho.network;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import xyz.thedevspot.voiperinho.models.LoginResponse;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginSocketListener;

/**
 * Created by foi on 11/01/16.
 */
public class RecieverSocket implements Runnable {

    private Socket client;

    private InputStream inputStream;

    private Handler handler;

    private Object listener;

    private boolean isAuthorized;

    public RecieverSocket(Socket client, Handler handler, Object listener, boolean isAuthorized) {
        this.client = client;
        this.handler = handler;
        this.listener = listener;
        this.isAuthorized = isAuthorized;

        try {
            this.inputStream = client.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (!isAuthorized) {
            authorize();
        }

    }

    private void authorize() {
        String response = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //Wait for response
        try {
            response = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final LoginSocketListener loginListener = (LoginSocketListener) listener;

        if (!TextUtils.isEmpty(response)) {

            //Convert response to JSON
            Gson gson = new Gson();
            final LoginResponse loginResponse = gson.fromJson(response, LoginResponse.class);

            if (loginResponse.getStatus() == 200) {
                isAuthorized = true;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginListener.onLoginSuccess(loginResponse.getMessage().getId());
                    }
                });
            } else {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginListener.onLoginFail();
                    }
                });
            }
        }
    }
}
