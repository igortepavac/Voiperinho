package xyz.thedevspot.voiperinho.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.adapters.ContactsAdapter;

public class SearchActivity extends BaseActivity {

    @Bind(R.id.search_list)
    ListView searchListView;

    @Bind(R.id.search_go)
    Button searchGo;

    @Bind(R.id.search_username)
    EditText searchUsername;

    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initToolbar(null, null, true);
    }

    @OnClick(R.id.search_go)
    protected void onClickGo() {

    }
}
