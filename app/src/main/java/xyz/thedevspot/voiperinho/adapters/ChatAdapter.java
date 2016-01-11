package xyz.thedevspot.voiperinho.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.models.Message;

/**
 * Created by foi on 11/01/16.
 */
public class ChatAdapter extends ArrayAdapter<Message> {

    public ChatAdapter(Context context, List<Message> messageList) {
        super(context, R.layout.list_item_chat, messageList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_chat, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Message message = getItem(position);

        holder.messageUsername.setText(message.getSender());
        String time = message.getTimestamp() + ":";
        holder.messageTimestamp.setText(time);
        holder.messageContent.setText(message.getContent());

        return convertView;
    }

    static class ViewHolder {

        @Bind(R.id.chat_username)
        TextView messageUsername;

        @Bind(R.id.chat_timestamp)
        TextView messageTimestamp;

        @Bind(R.id.chat_content)
        TextView messageContent;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
