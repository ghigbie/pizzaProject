package com.geogehigbie.pizzabuilder;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import layout.ToppingsStart;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> pizzaNamesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizzaNamesArrayList = getIntent().getStringArrayListExtra("pizzaNamesArrayList");

        centerActionBar();
        addOnClickListeners();
    }

    private void centerActionBar(){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //this is a soft error
        getSupportActionBar().setCustomView(R.layout.title_center);
    }

    private void addOnClickListeners(){
        ImageView pizzaImage = (ImageView) findViewById(R.id.pizzaImage);
        pizzaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToppingsStart toppingsStart = new ToppingsStart();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("pizzaNamesArrayList", pizzaNamesArrayList);
                toppingsStart.setArguments(bundle);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, toppingsStart);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

}
