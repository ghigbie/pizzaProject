package com.geogehigbie.pizzabuilder;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by georgehigbie on 2/6/17.
 */

public class CustomListAdapterPizza extends ArrayAdapter<String> {


    public CustomListAdapterPizza(Context context, ArrayList<String> values) {
        super(context, 0, values);
    }



}


