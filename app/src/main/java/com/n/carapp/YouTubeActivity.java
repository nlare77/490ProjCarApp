package com.n.carapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.n.carapp.core.CarInfo;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by jpapp_000 on 12/7/2014.
 */
public class YouTubeActivity extends Activity {

    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;
    private List<CarInfo> carlist = null;
    RemoteDataTask task= null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.youtubelistview);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(YouTubeActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Car Videos");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "CarClass");
            query.orderByAscending("carmake");
            try {
                ob = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute (Void result){
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.videolistview);
            // Pass the results into an ArrayAdapter
            adapter = new ArrayAdapter<String>(YouTubeActivity.this,R.layout.youtubelistviewitem);
            // Retrieve object "name" from Parse.com database
            for (ParseObject car : ob) {
                adapter.add((String) car.get("CarMake"));
            }

            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
            // Capture button clicks on ListView items
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // Send single item click data to SingleItemView Class
                    Intent i = new Intent(YouTubeActivity.this,
                            YoutubeFragment.class);
                    // Pass data "name" followed by the position
                    i.putExtra("youtubekey", ob.get(position).getString("youtubekey")
                            .toString());
                    // Open SingleItemView.java Activity
                    startActivity(i);
                }
            });
        }

        }
    }

