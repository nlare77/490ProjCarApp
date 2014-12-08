package com.n.carapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Nick7 on 12/7/2014.
 */
public class MapFragment extends Activity {

    private GoogleMap mMap;
    static final LatLng PERTH = new LatLng(-31.90, 115.86);
    static final LatLng LOU = new LatLng(38.25, -85.77);
    static final LatLng NY = new LatLng(40.71, -74.00);


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);





        /*mMap = ((com.google.android.gms.maps.MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();



        Marker perth = mMap.addMarker(new MarkerOptions()
                .position(PERTH)
                .title("Perth, Australia")
                .draggable(true));

        Marker lou = mMap.addMarker(new MarkerOptions()
                .position(LOU)
                .title("Louisville, KY")
                .draggable(true));

        Marker ny = mMap.addMarker(new MarkerOptions()
                .position(NY)
                .title("New York City, NY")
                .draggable(true)); */


    }
}