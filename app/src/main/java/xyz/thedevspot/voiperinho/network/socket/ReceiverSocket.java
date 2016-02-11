package xyz.thedevspot.voiperinho.network.socket;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import xyz.thedevspot.voiperinho.models.LoginResponse;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.listeners.Listener;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginCallback;

/**
 * Created by foi on 11/01/16.
 */
public class ReceiverSocket implements Runnable {

    private Socket client;

    private BufferedReader reader;

    private Handler handler;

    private LoginCallback callback;

    private Listener<Message> chatListener;

    private boolean isAuthorized;

    private static ReceiverSocket instance;

    private ReceiverSocket(Socket client, LoginCallback callback) {
        this.client = client;
        this.callback = callback;
        this.handler = new Handler(Looper.getMainLooper());
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

    public static ReceiverSocket getInstance(Socket client, LoginCallback listener) {
        if (instance == null) {
            instance = new ReceiverSocket(client, listener);
        }
        return instance;
    }

    public Socket getClient() {
        return this.client;
    }

    public void setChatListener(Listener<Message> listener) {
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
                        callback.onLoginSuccess(loginResponse.getMessage());
                    }
                });
            } else {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onLoginFail();
                    }
                });
            }
        }
    }

    private void listenForMessages() {
        String response = "";
        while (!client.isClosed() && isAuthorized) {
            try {
                response = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!TextUtils.isEmpty(response)) {
                Gson gson = new Gson();
                final Message message = gson.fromJson(response, Message.class);

                if (chatListener != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            chatListener.onSuccess(message);
                        }
                    });
                }
            }
        }
    }
}
