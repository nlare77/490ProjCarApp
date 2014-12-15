package com.n.carapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.n.carapp.R;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.SaveCallback;

/**
 * Created by Nick7 on 12/14/2014.
 */
public class RequestActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.n.carapp.MESSAGE";

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_request);

            Parse.initialize(this, "cNBKPDRaTQqbCZeMbnLSlrwEfgLMcsRaRTdQdycm", "j3Yqr0OvjC8A6gSAVCMcfsAVtwYwaqYEwYJ9OE6j");
            ParsePush.subscribeInBackground("", new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                    } else {
                        Log.e("com.parse.push", "failed to subscribe for push", e);
                    }
                }
            });
        }
            @Override
            public boolean onCreateOptionsMenu (Menu menu){
                getMenuInflater().inflate(R.menu.requestactivitymenu, menu);
                return true;
            }


            @Override
            public boolean onOptionsItemSelected(MenuItem item) {

                int id = item.getItemId();

                switch (id){

                    case R.id.requestList : requestlist(); return true;
                    default:return false;
                }
            }




    private void requestlist() {
        Intent requestlistintent = new Intent(RequestActivity.this,RequestList.class);
        RequestActivity.this.startActivity(requestlistintent);

    }
    public void sendRequest(View view) {
        Intent intent = new Intent(this, RequestList.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String request = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, request);


        startActivity(intent);

        ParseObject userMessage = new ParseObject("Requests");
        userMessage.put("request", request);
        userMessage.saveInBackground();
    }
}
