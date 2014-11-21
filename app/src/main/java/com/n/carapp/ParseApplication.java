package com.n.carapp;


import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import com.parse.PushService;


/**
 * Created by jpapp_000 on 11/20/2014.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "cNBKPDRaTQqbCZeMbnLSlrwEfgLMcsRaRTdQdycm", "j3Yqr0OvjC8A6gSAVCMcfsAVtwYwaqYEwYJ9OE6j");


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }



}
