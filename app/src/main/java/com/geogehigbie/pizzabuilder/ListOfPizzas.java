package com.geogehigbie.pizzabuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class ListOfPizzas extends AppCompatActivity {
    private ArrayList<String> toppingsArrayList;
    private ArrayList<String> pizzaNamesArrayList;
    private ArrayList<Pizza> pizzasArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_pizzas);

        Intent intent = getIntent();
        toppingsArrayList = intent.getStringArrayListExtra("toppingsArrayList");
        pizzaNamesArrayList = intent.getStringArrayListExtra("pizzaNamesArrayList");

        ListView listView = (ListView) findViewById(R.id.pizzaListView);
        CustomListAdapterPizza listAdapterPizza = new CustomListAdapterPizza(this, pizzaNamesArrayList);
        listView.setAdapter(listAdapterPizza);
    }

}
