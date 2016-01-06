package xyz.thedevspot.voiperinho.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foi on 06/01/16.
 */
public class RegisterRequest {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("avatar")
    private String avatar;

    public RegisterRequest(String username, String password, String email, String avatar) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
