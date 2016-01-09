package xyz.thedevspot.voiperinho.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import xyz.thedevspot.voiperinho.mvp.views.ContactsView;

public class MainActivity extends BaseActivity implements ContactsView, AdapterView.OnItemClickListener {

    @Bind(R.id.contact_list)
    ListView contactListView;

    @Bind(R.id.no_contacts)
    TextView emptyContactList;

    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MvpFactory.getPresenter(this).getContacts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO: open conversation
        showError(R.string.conversation_error);
    }

    @Override
    public void onContactsReceived(List<User> contactList) {
        adapter = new ContactsAdapter(this, contactList);
        contactListView.setAdapter(adapter);
        contactListView.setOnItemClickListener(this);
    }

    @Override
    public void onContatcsEmpty() {
        contactListView.setEmptyView(emptyContactList);
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void showError(@StringRes int error) {
        showErrorMessage(getString(error));
    }
}
