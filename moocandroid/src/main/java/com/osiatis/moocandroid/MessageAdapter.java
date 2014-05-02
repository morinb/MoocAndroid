package com.osiatis.moocandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Listview Adapter that inflate the layout to display multiple lines.
 */
public class MessageAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final List<Message> messagesList;

    public MessageAdapter(Context context, List<Message> messagesList) {
        super(context, R.layout.row, messagesList);

        this.context = context;
        this.messagesList = messagesList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create a layout inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2.  get row view from inflater
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // 3. Get the two text view from the row view
        assert rowView != null;
        final TextView messageView = (TextView) rowView.findViewById(R.id.row_message);
        final TextView usernameView = (TextView) rowView.findViewById(R.id.row_username);

        // 4. sets the text
        messageView.setText(messagesList.get(position).getMessage());
        usernameView.setText(context.getString(R.string.from) + " " + messagesList.get(position).getUserName() + "(" + messagesList.get(position).getTime() + ")");


        return rowView;
    }
}
