package com.n.carapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nick7 on 11/30/2014.
 */
public class SingleItemView extends Activity {
    // Declare Variables
    String brand;
    String model;
    String engine;
    String sixtyTime;
    String topSpeed;

    String carImage;
    String position;
    ImageLoader imageLoader = new ImageLoader(this);
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);
        new RemoteDataTask().execute();


        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /*
        ActionBar.Tab tab1 = actionBar.newTab().setText("More Cars");
        tab1.setTabListener(new TabListener(new MoreCarsFragment()));
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab().setText("tab2");
        tab2.setTabListener(new TabListener(new Tab2Fragment()));
        actionBar.addTab(tab2);

        ActionBar.Tab tab3 = actionBar.newTab().setText("tab3");
        tab3.setTabListener(new TabListener(new Tab3Fragment()));
        actionBar.addTab(tab3); */

        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab tab = actionBar.newTab()
                .setText("Details");
        tab.setTabListener(new TabListener(
                this, "Details", DetailsFragment.class));
        actionBar.addTab(tab);

       tab = actionBar.newTab()
                .setText("Dealership on Map");
        tab.setTabListener(new TabListener(
                this, "Dealership on Map", MapFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Video")
                .setTabListener(new TabListener(
                        this, "Video", VideoFragment.class));
        actionBar.addTab(tab);

       /* Intent i = getIntent();

        brand = i.getStringExtra("brand");

        model = i.getStringExtra("model");

        // Get the result of flag
        carImage = i.getStringExtra("car image");

        // Locate the TextViews in singleitemview.xml
        TextView txtbrand = (TextView) findViewById(R.id.brand);
        TextView txtmodel = (TextView) findViewById(R.id.model);


        // Locate the ImageView in singleitemview.xml
        ImageView imgCar = (ImageView) findViewById(R.id.carImage);

        // Set results to the TextViews
        txtbrand.setText(brand);
        txtmodel.setText(model);


        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(carImage, imgCar); */

    }


     private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(SingleItemView.this);
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
            Intent i = getIntent();

            brand = i.getStringExtra("brand");

            model = i.getStringExtra("model");

            engine = i.getStringExtra("engine");

            sixtyTime = i.getStringExtra("sixtyTime");

            topSpeed = i.getStringExtra("topSpeed");


            carImage = i.getStringExtra("car image");


            TextView txtbrand = (TextView) findViewById(R.id.brand);
            TextView txtmodel = (TextView) findViewById(R.id.model);
            TextView txtsixtyTIme = (TextView) findViewById(R.id.sixtyTime);
            TextView txtengine = (TextView) findViewById(R.id.engine);
            TextView txttopSpeed = (TextView) findViewById(R.id.topSpeed);



            // Locate the ImageView in singleitemview.xml
            ImageView imgCar = (ImageView) findViewById(R.id.carImage);

            // Set results to the TextViews
            txtbrand.setText(brand);
            txtmodel.setText(model);
            txtengine.setText(engine);
            txtsixtyTIme.setText(sixtyTime);
            txttopSpeed.setText(topSpeed);


            // Capture position and set results to the ImageView
            // Passes flag images URL into ImageLoader.class
            imageLoader.DisplayImage(carImage, imgCar);
            return null;

        }
        @Override
        protected void onPostExecute (Void result){
            mProgressDialog.dismiss();
        }
    }
    public void startMap(View view) {
        Intent intent = new Intent(this, MapFragment.class);


        startActivity(intent);
    }

    }

