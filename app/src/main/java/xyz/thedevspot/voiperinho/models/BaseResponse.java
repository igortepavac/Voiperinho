package xyz.thedevspot.voiperinho.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foi on 11/01/16.
 */
public class BaseResponse<T> {

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private T message;

    @SerializedName("error_message")
    private String errorMessage;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
