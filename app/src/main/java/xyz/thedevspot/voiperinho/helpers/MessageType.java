package xyz.thedevspot.voiperinho.helpers;

/**
 * Created by foi on 13/01/16.
 */
public enum MessageType {
    MESSAGE, PING, REQUEST, ACCEPT, ONLINE, CALL, DISCONNECT;

    @Override
    public String toString() {
        String ret = "";
        switch (this) {
            case MESSAGE:
                break;

            case PING:
                ret = "/ping";
                break;

            case REQUEST:
                ret = "/request";
                break;

            case ACCEPT:
                ret = "/accept";
                break;

            case ONLINE:
                ret = "/online";
                break;

            case CALL:
                ret = "/call";
                break;

            case DISCONNECT:
                ret = "/disconnect";
                break;
        }
        return ret;
    }
}
