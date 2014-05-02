package com.osiatis.moocandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends Activity {
    private List<Message> messages = new LinkedList<Message>();
    private String userName = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }


    /**
     * Click on Ok button,
     */
    public void onButtonNameClick(View view) {
        Log.i("main", "Name selection button clicked.");

        final EditText editTextName = (EditText) findViewById(R.id.editTextName);
        final TextView textViewLabelName = (TextView) findViewById(R.id.textViewLabelName);
        final Button buttonNameValidation = (Button) findViewById(R.id.buttonNameValidation);
        final Button buttonSendMessage = (Button) findViewById(R.id.buttonSendMessage);

        // Gets the userName and change the welcome message.

        userName = editTextName.getText().toString();

        textViewLabelName.setText(getString(R.string.welcome_name) + " " + userName);

        // Hiding editText and button, we no more need them.
        editTextName.setVisibility(View.INVISIBLE);
        buttonNameValidation.setVisibility(View.INVISIBLE);

        buttonSendMessage.setEnabled(true);
    }

    /**
     * Click on send message button. Adds an entry in the list.
     */
    public void onButtonSendMessageClick(View view) {
        final ListView listView = (ListView) findViewById(R.id.listView);
        final EditText editTextMessage = (EditText) findViewById(R.id.editTextMessage);

        // send message only if text is not empty.
        if (!editTextMessage.getText().toString().isEmpty()) {
            messages.add(new Message(userName, editTextMessage.getText().toString()));

            MessageAdapter adapter = new MessageAdapter(this, messages);

            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            listView.setSelection(messages.size());

            // clears the message text view
            editTextMessage.setText("");
        }
    }
}
