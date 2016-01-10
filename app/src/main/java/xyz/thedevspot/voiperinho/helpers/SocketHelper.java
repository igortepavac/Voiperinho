package xyz.thedevspot.voiperinho.helpers;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import xyz.thedevspot.voiperinho.models.LoginResponse;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.LoginInteractorImpl;

/**
 * Created by foi on 09/01/16.
 */
public class SocketHelper extends Thread {

    private static final String ADDRESS = "http://thedevspot.xyz";

    private static final int PORT = 9999;

    private InputStream inputStream;

    private OutputStream outputStream;

    private Socket socket;

    private LoginInteractorImpl.LoginResponseListener listener;

    private String username;

    private String password;

    public SocketHelper(LoginInteractorImpl.LoginResponseListener listener, String username, String password) {
        this.listener = listener;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        if (tryConnect()) {
            if (!tryAuthorize(username, password)) {
                listener.onLoginFail();
            }
        } else {
            listener.onLoginFail();
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

    public boolean tryAuthorize(String username, String password) {
        boolean ret = false;
        String response = "";

        PrintWriter writer = new PrintWriter(outputStream, true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String credentials = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }\n";
        writer.println(credentials);

        try {
            response = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!TextUtils.isEmpty(response)) {
            Gson gson = new Gson();
            LoginResponse loginResponse = gson.fromJson(response, LoginResponse.class);
            if (loginResponse.getStatus() == 200) {
                listener.onLoginSuccess(loginResponse.getMessage().getId());
                ret = true;
            }
        }

        return ret;
    }
}
