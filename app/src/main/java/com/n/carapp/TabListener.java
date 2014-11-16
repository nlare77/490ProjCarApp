package com.n.carapp;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by jpapp_000 on 11/16/2014.
 */
public class TabListener implements ActionBar.TabListener {

    private  Fragment fragment;
    public TabListener(Fragment fragment){
        this.fragment=fragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
