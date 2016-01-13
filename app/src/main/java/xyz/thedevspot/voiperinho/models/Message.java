package xyz.thedevspot.voiperinho.models;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import xyz.thedevspot.voiperinho.helpers.MessageType;

/**
 * Created by foi on 11/01/16.
 */
public class Message {

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("content")
    private String content;

    @SerializedName("receiver")
    private String receiver;

    @SerializedName("sender")
    private String sender;

    @SerializedName("command")
    private String command;

    public Message() {
    }

    public Message(String content, String receiver, String sender, MessageType command) {
        this.content = content;
        this.receiver = receiver;
        this.sender = sender;
        this.command = command.toString();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setTimeStamp() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        this.timestamp = dateFormat.format(new Date());
    }
}
