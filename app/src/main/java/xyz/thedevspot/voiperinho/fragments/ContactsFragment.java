package xyz.thedevspot.voiperinho.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import xyz.thedevspot.voiperinho.mvp.presenters.ContactsPresenter;
import xyz.thedevspot.voiperinho.mvp.views.ContactsView;

/**
 * Created by foi on 10/01/16.
 */
public class ContactsFragment extends BaseFragment implements ContactsView, AdapterView.OnItemClickListener {

    @Bind(R.id.contact_list)
    ListView contactListView;

    @Bind(R.id.no_contacts)
    TextView twEmptyContacts;

    private ContactsPresenter presenter;

    private ContactsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        ButterKnife.bind(this, view);

        presenter = MvpFactory.getPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.getContacts();
    }

    @Override
    public void onContactsReceived(List<User> contactList) {
        adapter = new ContactsAdapter(getActivity(), contactList, true);
        contactListView.setAdapter(adapter);
        contactListView.setOnItemClickListener(this);
    }

    @Override
    public void onContatcsEmpty() {
        contactListView.setEmptyView(twEmptyContacts);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onContactClick(adapter.getItem(position).getId());
        // TODO: open conversation
        showMessage(R.string.conversation_error);
    }
}
