package xyz.thedevspot.voiperinho.helpers;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by foi on 09/01/16.
 */
public class SocketHelper extends Thread {

    private static final String ADDRESS = "127.0.0.1";

    private static final int PORT = 9999;

    private Socket socket;

    public boolean tryConnect() {
        boolean ret = false;
        try {
            InetAddress address = InetAddress.getByName(ADDRESS);
            socket = new Socket(address, PORT);

            ret = true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO: add more info about the connection

        return ret;
    }

    public boolean tryAuthorize(String username, String password) {
        boolean ret = false;

        String credentials = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }\n";

        // TODO: authorize

        return ret;
    }

}
