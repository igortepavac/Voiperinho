package xyz.thedevspot.voiperinho.network;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import xyz.thedevspot.voiperinho.helpers.MessageType;
import xyz.thedevspot.voiperinho.models.Message;

/**
 * Created by foi on 11/01/16.
 */
public class SenderSocket implements Runnable {

    private Socket client;

    private PrintWriter writer;

    private Message message;

    public SenderSocket(Socket client, Message message) {
        this.client = client;
        this.message = message;

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

        if (TextUtils.equals(message.getCommand(), MessageType.DISCONNECT.toString())) {
            try {
                ReceiverSocket.getInstance().getClient().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
