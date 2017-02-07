package com.geogehigbie.pizzabuilder;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import layout.PizzaList;
import layout.ToppingsStart;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by georgehigbie on 1/31/17.
 */

public class PizzaBuilderStart extends AppCompatActivity {

    ArrayList<String> toppingsArrayList;
    ArrayList<String> pizzaNamesArrayList;
    ArrayList<Pizza> pizzasArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_builder_start);

        toppingsArrayList = new ArrayList<String>();
        pizzaNamesArrayList = new ArrayList<String>();
        pizzasArrayList = new ArrayList<Pizza>();

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

        Button enterButton = (Button) findViewById(R.id.enter_start);
       // Button noButton = (Button) findViewById(R.id.no_start);
        final Button seeListPizzasButton = (Button) findViewById(R.id.seeListOfPizza);

        EditText editText = (EditText) findViewById(R.id.edit_text_pizza_name);
        if(editText != null) {
            enterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //creating parameters to be passed into new Object - pizza
                    EditText editText = (EditText) findViewById(R.id.edit_text_pizza_name);
                    String name = editText.getText().toString();
                    pizzaNamesArrayList.add(name);//adds name of pizza to button

                    seeListPizzasButton.setVisibility(View.VISIBLE);

                    Pizza pizzaNew = new Pizza(name, toppingsArrayList);

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("toppingsArraysList", toppingsArrayList);
                    ToppingsStart toppingsStart = new ToppingsStart(); //creates a new fragment
                    toppingsStart.setArguments(bundle);

                    fragmentTransaction.add(R.id.fragment_container, toppingsStart);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }else{
            Toast toast = Toast.makeText(this, "Please give your pizza a name to begin", Toast.LENGTH_SHORT);
            toast.show();
        }

//        noButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        seeListPizzasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PizzaList pizzaList = new PizzaList();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("pizzaNamesArrayList", pizzaNamesArrayList);

                fragmentTransaction.add(R.id.fragment_container, pizzaList);
                pizzaList.setArguments(bundle); //sets the array list to be transfered to the pizza names page
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

}
