package com.creativeideas.kongkow;

import android.app.Application;

import com.strongloop.android.loopback.RestAdapter;

/**
 * Created by Kadek_P on 4/13/2016.
 */
public class KongkowApplication extends Application {
    RestAdapter adapter;

    public RestAdapter getLoopBackAdapter() {
        if (adapter == null) {
            // Instantiate the shared RestAdapter. In most circumstances,
            // you'll do this only once; putting that reference in a singleton
            // is recommended for the sake of simplicity.
            // However, some applications will need to talk to more than one
            // server - create as many Adapters as you need.
            adapter = new RestAdapter(
                    getApplicationContext(), "https://kongkow-backend.herokuapp.com/api");
        }
        return adapter;
    }
}
