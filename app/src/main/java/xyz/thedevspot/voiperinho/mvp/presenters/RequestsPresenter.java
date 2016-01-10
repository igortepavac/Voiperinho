package xyz.thedevspot.voiperinho.mvp.presenters;

/**
 * Created by foi on 10/01/16.
 */
public interface RequestsPresenter {

    void getRequests();

    void onRequestClick(boolean accept);
}
