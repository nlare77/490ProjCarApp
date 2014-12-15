package com.n.carapp.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.n.carapp.core.CarInfo;
import com.n.carapp.adapter.ListViewAdapter;
import com.n.carapp.R;
import com.n.carapp.YouTubeActivity;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<CarInfo> carinfolist = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);



        new RemoteDataTask().execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.videos : videos(); return true;
            case R.id.add : addCar(); return true;
            case R.id.request : requests(); return true;
            default:return false;
        }
    }

    private void videos() {
        Intent videointent = new Intent(MainActivity.this,YouTubeActivity.class);
        MainActivity.this.startActivity(videointent);

    }

    private void addCar() {
        Intent addcarintent = new Intent(MainActivity.this,AddCarActivity.class);
        MainActivity.this.startActivity(addcarintent);

    }

    private void requests() {
        Intent requestintent = new Intent(MainActivity.this,RequestActivity.class);
        MainActivity.this.startActivity(requestintent);

    }

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {


        @Override
            protected void onPreExecute() {

                super.onPreExecute();
                // Create a progressdialog
                mProgressDialog = new ProgressDialog(MainActivity.this);
                // Set progressdialog title
                mProgressDialog.setTitle("Retrieving Car List ");
                // Set progressdialog message
                mProgressDialog.setMessage("Loading...");
                mProgressDialog.setIndeterminate(false);
                // Show progressdialog
                mProgressDialog.show();

            }

            @Override
            protected Void doInBackground(Void... params) {
                // Create the array
                carinfolist = new ArrayList<CarInfo>();
                try {

                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                            "CarClass");

                    query.orderByAscending("carmake");
                    ob = query.find();
                    for (ParseObject CarMake : ob) {

                        ParseFile image = (ParseFile) CarMake.get("CarImages");

                        CarInfo map = new CarInfo();
                        map.setBrand((String) CarMake.get("CarModel"));
                        map.setModel((String) CarMake.get("CarMake"));
                        map.setEngine((String) CarMake.get("Engine"));
                        map.setSixtyTime((String) CarMake.get("sixtyTime"));
                        map.setTopSpeed((String) CarMake.get("TopSpeed"));
                        map.setCarImage(image.getUrl());
                        map.setVideoID(image.getUrl());

                        carinfolist.add(map);
                    }
                } catch (ParseException e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }



                @Override
                protected void onPostExecute (Void result){

                    listview = (ListView) findViewById(R.id.listViewBrands);

                    adapter = new ListViewAdapter(MainActivity.this,
                            carinfolist);
                    // Binds the Adapter to the ListView
                    listview.setAdapter(adapter);
                    // Close the progressdialog
                    mProgressDialog.dismiss();


                }

            }

        }



