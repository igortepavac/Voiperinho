package xyz.thedevspot.voiperinho.network;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.listeners.ChatListener;

/**
 * Created by foi on 11/01/16.
 */
public class SenderSocket implements Runnable {

    private Socket client;

    private PrintWriter writer;

    private Message message;

    private Object listener;

    public SenderSocket(Socket client, Message message, Object listener) {
        this.client = client;
        this.message = message;
        this.listener = listener;

        try {
            this.writer = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Gson gson = new Gson();
        String json = gson.toJson(message);
        writer.println(json);

        ChatListener chatListener = (ChatListener) listener;
        chatListener.onMessageSuccess(message);
    }
}
