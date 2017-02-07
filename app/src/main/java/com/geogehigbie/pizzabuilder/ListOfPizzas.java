package com.geogehigbie.pizzabuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import layout.ToppingsListTwo;


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

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        ToppingsListTwo toppingsListTwo = new ToppingsListTwo();
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("toppingsArrayList", toppingsArrayList);
                        toppingsListTwo.setArguments(bundle);

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.fragment_container2, toppingsListTwo);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                }

        );

        setOnClickListener();
    }

    public void setOnClickListener(){
        Button button = (Button) findViewById(R.id.createNewPizza1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
