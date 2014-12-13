package com.n.carapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nick7 on 12/7/2014.
 */
public class VideoFragment extends Fragment {

    @Override
    public View onCreateView
            (LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        return view;
    }
}
