package com.n.carapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by jpapp_000 on 11/16/2014.
 */
public class TabListener<T extends Fragment> implements ActionBar.TabListener {

    private Activity mActivity;
    private  Fragment mFragment;
    private final Class<T> mClass;
    private final String mTag;

   /*public TabListener(Fragment fragment){
        this.fragment=fragment;
    } */
    public TabListener(Activity activity, String tag, Class<T> clz) {
        mActivity = activity;
        mTag = tag;
        mClass = clz;

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        if (mFragment == null) {
            // If not, instantiate and add it to the activity
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ft.add(android.R.id.content, mFragment, mTag);
        } else {

            // If it exists, simply attach it in order to show it
            ft.attach(mFragment);
            //  ft.replace(R.id.container, mFragment);
        }
    }


    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(mFragment);


    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
