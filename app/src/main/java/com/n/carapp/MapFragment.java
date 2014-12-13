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
    static final LatLng POR = new LatLng (38.243127, -85.627982);
    static final LatLng FER = new LatLng (38.252167, -85.637608);
    static final LatLng COR = new LatLng (38.220224, -85.578228);
    static final LatLng TES = new LatLng (37.494741, -121.944154);
    static final LatLng NIS = new LatLng (38.251875, -85.642990);
    static final LatLng HON = new LatLng (38.217220, -85.581681);
    static final LatLng DIA =  new LatLng (38.670477, -90.608892);
    static final LatLng PRI = new LatLng (38.250711, -85.605379);



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);





        mMap = ((com.google.android.gms.maps.MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        Marker boxster = mMap.addMarker(new MarkerOptions()
                .position(POR)
                .title("Blue Grass Porsche: Porsche"));

        Marker californiaT = mMap.addMarker(new MarkerOptions()
                .position(FER)
                .title("Louisville Fine Motorcars : Ferrari"));

        Marker corvette = mMap.addMarker(new MarkerOptions()
                .position(COR)
                .title("Bachman Chevrolet: Corvette"));

        Marker modelS = mMap.addMarker(new MarkerOptions()
                .position(TES)
                .title("Tesla Factory: Model S"));

        Marker nissan = mMap.addMarker(new MarkerOptions()
                .position(NIS)
                .title("Neil Huffman Nissan: Pathfinder, Sentra, Maxima"));

        Marker honda = mMap.addMarker(new MarkerOptions()
                .position(HON)
                .title("Sam Swope Honda World: Civic"));

        Marker toyota = mMap.addMarker(new MarkerOptions()
                .position(PRI)
                .title("Oxmoor Toyota: Camry, Prius"));

        Marker diablo = mMap.addMarker(new MarkerOptions()
                .position(DIA)
                .title("Lamborghini St Louis: Diablo"));




    }
}