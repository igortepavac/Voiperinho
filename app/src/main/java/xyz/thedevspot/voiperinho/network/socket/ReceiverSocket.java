package xyz.thedevspot.voiperinho.network.socket;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.network.callbacks.ChatCallback;
import xyz.thedevspot.voiperinho.network.callbacks.LoginCallback;

/**
 * Created by foi on 11/01/16.
 */
public class ReceiverSocket implements Runnable {

    private Socket client;

    private BufferedReader reader;

    private Handler handler;

    private LoginCallback loginCallback;

    private ChatCallback chatCallback;

    private boolean isAuthorized;

    private static ReceiverSocket instance;

    private ReceiverSocket(Socket client, LoginCallback loginCallback) {
        this.client = client;
        this.loginCallback = loginCallback;
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

    public void setChatCallback(ChatCallback chatCallback) {
        this.chatCallback = chatCallback;
    }

    /**
     * Receives authorization response from the server and notifies the caller accordingly.
     */
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
            final BaseResponse<User> loginResponse = gson.fromJson(response, new TypeToken<BaseResponse<User>>(){}.getType());

            if (loginResponse.getStatus() == 200) {
                isAuthorized = true;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginCallback.onLoginSuccess(loginResponse.getMessage());
                    }
                });
            } else {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginCallback.onLoginFail();
                    }
                });
            }
        }
    }

    /**
     * Receives all messages from the server.
     * Communicates with the main thread via callbacks.
     */
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

                if (chatCallback != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            chatCallback.onMessageReceived(message);
                        }
                    });
                }
            }
        }
    }
}
