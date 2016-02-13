package xyz.thedevspot.voiperinho.mvp.interactors;

import java.util.List;

import xyz.thedevspot.voiperinho.models.RequestInformation;
import xyz.thedevspot.voiperinho.listeners.Listener;

/**
 * Created by foi on 10/01/16.
 */
public interface RequestsInteractor {

    void getRequests(Listener<List<RequestInformation>> listener);

    void acceptRequest(boolean accept);
}
