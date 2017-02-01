package com.geogehigbie.pizzabuilder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by georgehigbie on 1/31/17.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
