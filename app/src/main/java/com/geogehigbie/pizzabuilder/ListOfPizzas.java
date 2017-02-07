package com.geogehigbie.pizzabuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by georgehigbie on 2/6/17.
 */

public class ListOfPizzas extends AppCompatActivity {
    private ArrayList<String> toppingsArrayList;
    private ArrayList<String> pizzaNamesArrayList;
    private ArrayList<Pizza> pizzasArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        toppingsArrayList = intent.getStringArrayListExtra("toppingsArrayList");
        pizzaNamesArrayList = intent.getStringArrayListExtra("pizzaNamesArrayList");



        super.onCreate(savedInstanceState);
    }
}
