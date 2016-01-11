package xyz.thedevspot.voiperinho.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foi on 11/01/16.
 */
public class RequestInformation {

    @SerializedName("requester_id")
    private int id;

    @SerializedName("state")
    private int state;

    @SerializedName("requester")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
