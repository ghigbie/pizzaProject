package com.geogehigbie.pizzabuilder;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import layout.PizzaList;
import layout.ToppingsStart;

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
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //this may be a soft error
        getSupportActionBar().setCustomView(R.layout.title_center);
    }

    private void addClickListeners(){
        FragmentManager fragmentManager = getSupportFragmentManager(); //this allows access to all buttons
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Button yesButton = (Button) findViewById(R.id.yes_start);
        Button noButton = (Button) findViewById(R.id.no_start);
        Button seeListPizzasButton = (Button) findViewById(R.id.seeListOfPizza);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.add(R.id.fragment_container, new ToppingsStart());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        seeListPizzasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.add(R.id.fragment_container, new PizzaList());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}
