package xyz.thedevspot.voiperinho.helpers;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import xyz.thedevspot.voiperinho.mvp.listeners.LoginSocketListener;

/**
 * Created by foi on 09/01/16.
 */
public class SocketHelper implements Runnable {

    private static final String HOST = "http://thedevspot.xyz";

    private static final String ADDRESS = "46.101.167.213";

    //private static final String ADDRESS = "10.0.2.2";

    private static final int PORT = 9999;

    private InputStream inputStream;

    private OutputStream outputStream;

    private Socket socket;

    private Handler handler;

    private LoginSocketListener listener;

    private String username;

    private String password;

    public SocketHelper(LoginSocketListener listener, String username, String password) {
        this.listener = listener;
        this.username = username;
        this.password = password;
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void run() {
        if (tryConnect()) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onConnectionSuccess(socket);
                }
            });

            tryAuthorize(username, password);

        } else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onLoginFail();
                }
            });
        }
    }

    public boolean tryConnect() {
        boolean ret = false;

        try {
            socket = new Socket(ADDRESS, PORT);

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            ret = true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public void tryAuthorize(String username, String password) {
        PrintWriter writer = new PrintWriter(outputStream, true);

        String credentials = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }\n";
        writer.println(credentials);
    }
}
