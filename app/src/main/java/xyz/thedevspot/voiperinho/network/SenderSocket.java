package xyz.thedevspot.voiperinho.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by foi on 11/01/16.
 */
public class SenderSocket implements Runnable {

    private Socket client;

    private OutputStream outputStream;

    public SenderSocket(Socket client) {
        this.client = client;

        try {
            this.outputStream = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
