package com.n.carapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nick7 on 11/30/2014.
 */
public class SingleItemView extends Activity {
    // Declare Variables
    String brand;
    String model;

    String carImage;
    String position;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();

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
        imageLoader.DisplayImage(carImage, imgCar);
    }
}

