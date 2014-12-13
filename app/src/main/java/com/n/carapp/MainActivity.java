package com.n.carapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.AdapterView.OnItemClickListener;

import com.google.android.youtube.player.YouTubePlayerFragment;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    //ArrayList<String> carBrandNameList;
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

        /*ActionBar.Tab tab1 = actionBar.newTab().setText("Videos");
        tab1.setTabListener(new TabListener(new YouTubePlayerFragment()));
        actionBar.addTab(tab1);*/

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
            default:return false;
        }
    }

    private void videos() {
        Intent videointent = new Intent(MainActivity.this,YouTubeActivity.class);
        MainActivity.this.startActivity(videointent);

    }



    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {


        @Override
            protected void onPreExecute() {



                super.onPreExecute();
                // Create a progressdialog
                mProgressDialog = new ProgressDialog(MainActivity.this);
                // Set progressdialog title
                mProgressDialog.setTitle("Car App");
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


            //ListView carBrandList = (ListView)findViewById(R.id.listViewBrands);

            //carBrandNameList = new ArrayList<String>();
            //getBrandNames();

            //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carBrandNameList);
            //carBrandList.setAdapter(arrayAdapter);

            // START HERE JASON, if you comment this out, ListView works fine
            //carBrandList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            //{
            //public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            //{
            //Intent intent = new Intent (MainActivity.this, DetailsActivity.class);

            //startActivity(intent);
            //}
            //});





    /*void getBrandNames()
    {
        carBrandNameList.add("Ferrari");
        carBrandNameList.add("Tesla");
        carBrandNameList.add("Lamborghini");
    }*/
/*

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

                if (id == R.id.action_settings) {
                    return true;
                }
                return super.onOptionsItemSelected(item);
            }
*/
   /* private class ParseDataTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Car App");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        } */

      /*  @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "CarClass" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "CarClass");
            //query.orderByDescending("_created_at");
            try {
                ob = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        } */

          /*  @Override
            protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listViewBrands);
            // Pass the results into an ArrayAdapter
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                    R.layout.listview_itemadapter);
            // Retrieve object "CarMake" from Parse.com database
            for (ParseObject CarClass : ob) {
                adapter.add((String) CarClass.get("CarMake"));
            }
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();

        }


    }
*/
                @Override
                protected void onPostExecute (Void result){
                    // Locate the listview in listview_main.xml
                    listview = (ListView) findViewById(R.id.listViewBrands);
                    // Pass the results into ListViewAdapter.java
                    adapter = new ListViewAdapter(MainActivity.this,
                            carinfolist);
                    // Binds the Adapter to the ListView
                    listview.setAdapter(adapter);
                    // Close the progressdialog
                    mProgressDialog.dismiss();
                    /*// Capture button clicks on ListView items
                    listview.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            // Send single item click data to SingleItemView Class
                            Intent i = new Intent(MainActivity.this,
                                    DetailsActivity.class);
                            // Pass data "CarMake" followed by the position
                            i.putExtra("CarMake", ob.get(position).getString("CarMake"));
                            // Open SingleItemView.java Activity
                            startActivity(i);
                        }
                    });*/

                }




            }



        }

    /**
     * A placeholder fragment containing a simple view.
     */

