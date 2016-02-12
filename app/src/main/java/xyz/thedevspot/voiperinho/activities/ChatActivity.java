package xyz.thedevspot.voiperinho.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.adapters.ChatAdapter;
import xyz.thedevspot.voiperinho.helpers.MvpFactory;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.presenters.ChatPresenter;
import xyz.thedevspot.voiperinho.mvp.views.ChatView;

public class ChatActivity extends BaseActivity implements ChatView {

    private static String MESSAGE_LIST = "message_list";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.chat_send)
    Button sendButton;

    @Bind(R.id.chat_message)
    EditText chatMessage;

    @Bind(R.id.chat_list)
    ListView chatListView;

    private ChatAdapter adapter;

    private List<Message> messageList;

    private ChatPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        initToolbar(toolbar, SharedPreferencesHelper.getString(SharedPreferencesHelper.CONTACT), true);

        presenter = MvpFactory.getPresenter(this);

        if (savedInstanceState != null) {
            String json = savedInstanceState.getString(MESSAGE_LIST);
            messageList = presenter.deserializeMessageList(json);
            refreshMessageView();
        } else {
            messageList = new ArrayList<>();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(MESSAGE_LIST, presenter.serializeMessageList(messageList));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.chat_send)
    protected void onClickSend() {
        presenter.sendMessage(chatMessage.getText().toString());
    }

    @Override
    public void onMessageSuccess(Message message) {
        messageList.add(message);
        refreshMessageView();
        chatMessage.setText("");
    }

    @Override
    public void onMessageFail() {
        showMessage(R.string.something_wrong);
    }

    private void refreshMessageView() {
        adapter = new ChatAdapter(this, messageList);
        chatListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
