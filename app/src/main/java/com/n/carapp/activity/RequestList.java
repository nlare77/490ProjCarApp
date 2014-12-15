package com.n.carapp.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.n.carapp.R;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Nick7 on 12/14/2014.
 */
public class RequestList extends Activity {
    List<ParseObject> ob;
    ListView listview;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestlist);
        new ParseDataTask().execute();
    }
    private class ParseDataTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(RequestList.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Requests");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "Requests");
            //query.orderByDescending("_created_at");
            try {
                ob = query.find();
            } catch (com.parse.ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listViewRequests);
            // Pass the results into an ArrayAdapter
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(RequestList.this,
                    R.layout.listview_itemadapter2);

            for (ParseObject Requests : ob) {
                adapter.add((String) Requests.get("request"));
            }
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();



        }

    }
}
