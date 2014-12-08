package com.n.carapp;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nick7 on 12/7/2014.
 */
public class DetailsFragment extends Fragment {


    @Override
    public View onCreateView
            (LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.singleitemview, container, false);

        return view;
    }
}

