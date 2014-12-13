package com.n.carapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class DetailsActivity extends Activity {

    TextView txtname;
    String model;
    List<ParseObject> ob2;
    ProgressDialog mProgressDialog2;
    Bitmap image;
    ImageView imageofcar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details);

        /*ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab().setText("More Cars");
        tab1.setTabListener(new TabListener(new MoreCarsFragment()));
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab().setText("tab2");
        tab2.setTabListener(new TabListener(new Tab2Fragment()));
        actionBar.addTab(tab2);

        ActionBar.Tab tab3 = actionBar.newTab().setText("tab3");
        tab3.setTabListener(new TabListener(new Tab3Fragment()));
        actionBar.addTab(tab3); */



        // Locate the class table named "ImageUpload" in Parse.com
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                "CarClass");

        // Locate the objectId from the class
        query.getInBackground("OCZffPGa7E",
                new GetCallback<ParseObject>() {

                    public void done(ParseObject object,
                                     ParseException e) {
                        // TODO Auto-generated method stub

                        // Locate the column named "ImageName" and set
                        // the string
                        ParseFile fileObject = (ParseFile) object
                                .get("CarImages");
                        fileObject
                                .getDataInBackground(new GetDataCallback() {

                                    public void done(byte[] data,
                                                     ParseException e) {
                                        if (e == null) {
                                            Log.d("test",
                                                    "We've got data in data.");
                                            // Decode the Byte[] into
                                            // Bitmap
                                            Bitmap bmp = BitmapFactory
                                                    .decodeByteArray(
                                                            data, 0,
                                                            data.length);

                                            // Get the ImageView from
                                            // main.xml
                                            ImageView image = (ImageView) findViewById(R.id.carImage);

                                            // Set the Bitmap into the
                                            // ImageView
                                            image.setImageBitmap(bmp);



                                        } else {
                                            Log.d("test",
                                                    "There was a problem downloading the data.");
                                        }
                                    }
                                });
                    }
                });
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details, menu);
        setContentView(R.layout.fragment_details);

        Intent i = getIntent();

        model = i.getStringExtra("CarMake");



        txtname = (TextView) findViewById(R.id.model);

        txtname.setText(model);



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



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_details, container, false);
            return rootView;
        }
    }

        }






