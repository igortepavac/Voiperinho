package xyz.thedevspot.voiperinho.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.adapters.ContactsAdapter;
import xyz.thedevspot.voiperinho.helpers.MvpFactory;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.presenters.RequestsPresenter;
import xyz.thedevspot.voiperinho.mvp.views.RequestsView;

/**
 * Created by foi on 10/01/16.
 */
public class RequestsFragment extends BaseFragment implements RequestsView, AdapterView.OnItemClickListener {

    @Bind(R.id.requests_list)
    ListView requestListView;

    @Bind(R.id.no_requests)
    TextView twEmptyRequests;

    private RequestsPresenter presenter;

    private ContactsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_requests, container, false);
        ButterKnife.bind(this, view);

        presenter = MvpFactory.getPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.getRequests();
    }

    @Override
    public void onRequestsReceived(List<User> requestList) {
        adapter = new ContactsAdapter(getActivity(), requestList, false);
        requestListView.setAdapter(adapter);
        requestListView.setOnItemClickListener(this);
    }

    @Override
    public void onRequestsEmpty() {
        requestListView.setEmptyView(twEmptyRequests);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        new AlertDialog.Builder(getActivity())
                .setTitle(adapter.getItem(position).getUsername())
                .setMessage(getString(R.string.request_message))
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.onRequestClick(adapter.getItem(position).getId(), true);
                    }
                })
                .setNegativeButton(R.string.decline, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.onRequestClick(adapter.getItem(position).getId(),false);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}
