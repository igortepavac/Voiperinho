package xyz.thedevspot.voiperinho.mvp.listeners;

import java.util.List;

import xyz.thedevspot.voiperinho.models.RequestInformation;

/**
 * Created by foi on 11/01/16.
 */
public interface RequestsListener {

    void onRequestsReceived(List<RequestInformation> requestList);

    void onError();
}
