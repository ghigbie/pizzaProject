package com.geogehigbie.pizzabuilder;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by georgehigbie on 1/31/17.
 */

public class PizzaBuilderStart extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_builder_start);

        centerActionBar();
        addClickListeners();
    }

    private void centerActionBar(){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_center);
    }

    private void addClickListeners(){
        Button yesButton = (Button) findViewById(R.id.yes_start);
        Button noButton = (Button) findViewById(R.id.no_start);
        Button seeListButton = (Button) findViewById(R.id.)

    }
}
