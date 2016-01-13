package xyz.thedevspot.voiperinho.network;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import xyz.thedevspot.voiperinho.models.LoginResponse;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.listeners.ChatListener;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginSocketListener;

/**
 * Created by foi on 11/01/16.
 */
public class ReceiverSocket implements Runnable {

    private Socket client;

    private BufferedReader reader;

    private Handler handler;

    private LoginSocketListener loginListener;

    private ChatListener chatListener;

    private boolean isAuthorized;

    private static ReceiverSocket instance;

    private ReceiverSocket(Socket client, Handler handler, LoginSocketListener listener) {
        this.client = client;
        this.handler = handler;
        this.loginListener = listener;
        this.isAuthorized = false;

        try {
            this.reader= new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (!isAuthorized) {
            authorize();
        }

        listenForMessages();
    }


    public static ReceiverSocket getInstance() {
        return instance;
    }

    public static ReceiverSocket getInstance(Socket client, Handler handler, LoginSocketListener listener) {
        if (instance == null) {
            instance = new ReceiverSocket(client, handler, listener);
        }
        return instance;
    }

    public Socket getClient() {
        return this.client;
    }

    public void setChatListener(ChatListener listener) {
        this.chatListener = listener;
    }

    private void authorize() {
        String response = "";

        //Wait for response
        try {
            response = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!TextUtils.isEmpty(response)) {

            //Convert response to JSON
            Gson gson = new Gson();
            final LoginResponse loginResponse = gson.fromJson(response, LoginResponse.class);

            if (loginResponse.getStatus() == 200) {
                isAuthorized = true;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginListener.onLoginSuccess(loginResponse.getMessage());
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

    private void listenForMessages() {
        while (isAuthorized) {
            String response = "";

            try {
                response = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!TextUtils.isEmpty(response)) {
                Gson gson = new Gson();
                Message message = gson.fromJson(response, Message.class);

                if (chatListener != null) {
                    chatListener.onMessageSuccess(message);
                }
            }
        }
    }
}
