package xyz.thedevspot.voiperinho.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foi on 06/01/16.
 */
public class Credentials {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
