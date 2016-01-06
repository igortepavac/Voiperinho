package xyz.thedevspot.voiperinho.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foi on 06/01/16.
 */
public class LoginResponse {

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private User message;

    @SerializedName("error_message")
    private String errorMessage;

    public int getStatus() {
        return status;
    }

    public User getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(User message) {
        this.message = message;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
