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

import layout.PizzaList;
import layout.ToppingsStart;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

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

        Button enterButton = (Button) findViewById(R.id.enter_start);
       // Button noButton = (Button) findViewById(R.id.no_start);
        final Button seeListPizzasButton = (Button) findViewById(R.id.seeListOfPizza);

        EditText editText = (EditText) findViewById(R.id.edit_text_pizza_name);
        if(editText != null) {
            enterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText editText = (EditText) findViewById(R.id.edit_text_pizza_name);
                    String name = editText.getText().toString();

                    seeListPizzasButton.setVisibility(View.VISIBLE);


                    Pizza pizzaNew = new Pizza(name, )

                    fragmentTransaction.add(R.id.fragment_container, new ToppingsStart());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }else{
            Toast toast = Toast.makeText(this, "Please give your pizza a name to begin", Toast.LENGTH_SHORT);
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
                fragmentTransaction.add(R.id.fragment_container, new PizzaList());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

}
