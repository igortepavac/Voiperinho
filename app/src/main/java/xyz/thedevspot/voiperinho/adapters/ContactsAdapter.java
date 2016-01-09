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
import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 09/01/16.
 */
public class ContactsAdapter extends ArrayAdapter<User> {

    public ContactsAdapter(Context context, List<User> contactList) {
        super(context, R.layout.list_item_contact, contactList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_contact, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        User contact = getItem(position);

        holder.contactUsername.setText(contact.getUsername());

        return convertView;
    }

    static class ViewHolder {

        @Bind(R.id.contact_username)
        TextView contactUsername;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
