package com.n.carapp.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.n.carapp.core.ImageLoader;
import com.n.carapp.R;

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



            ImageView imgCar = (ImageView) findViewById(R.id.carImage);

            // Set results to the TextViews
            txtbrand.setText(brand);
            txtmodel.setText(model);
            txtengine.setText(engine);
            txtsixtyTIme.setText(sixtyTime);
            txttopSpeed.setText(topSpeed);



            imageLoader.DisplayImage(carImage, imgCar);
            return null;

        }

        @Override
        protected void onPostExecute(Void result) {
            mProgressDialog.dismiss();
        }
    }

    public void startMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);


        startActivity(intent);
    }
}




