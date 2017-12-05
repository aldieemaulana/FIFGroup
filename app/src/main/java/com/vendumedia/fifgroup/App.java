package com.vendumedia.fifgroup;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by aldimaulana on 17/11/2017 CE.
 */

public class App extends Application {

    public static final String API = "https://fema-dev.fifgroup.co.id/";

    public App() {
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/gt_book.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }

}
