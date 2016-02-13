package xyz.thedevspot.voiperinho.network.socket;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import xyz.thedevspot.voiperinho.network.LoginCallback;

/**
 * Created by foi on 09/01/16.
 */
public class AuthorizationSocket implements Runnable {

    private static final String ATTR_USERNAME = "{ \"username\": \"";

    private static final String ATTR_PASSWORD = "\", \"password\": \"";

    private static final String ATTR_ENDLINE = "\" }\n";

    //private static final String ADDRESS = "46.101.167.213";

    private static final String ADDRESS = "10.0.2.2";

    private static final int PORT = 9999;

    private OutputStream outputStream;

    private Socket socket;

    private Handler handler;

    private LoginCallback listener;

    private String username;

    private String password;

    public AuthorizationSocket(LoginCallback callback, String username, String password) {
        this.listener = callback;
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
                    listener.onConnectionFail();
                }
            });
        }
    }

    public boolean tryConnect() {
        boolean ret = false;

        try {
            socket = new Socket(ADDRESS, PORT);

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

        String credentials = ATTR_USERNAME + username + ATTR_PASSWORD + password + ATTR_ENDLINE;
        writer.println(credentials);
    }
}
