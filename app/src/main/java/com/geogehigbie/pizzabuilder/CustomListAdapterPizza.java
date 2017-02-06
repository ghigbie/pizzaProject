package com.geogehigbie.pizzabuilder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by georgehigbie on 2/6/17.
 */

public class CustomListAdapterPizza extends ArrayAdapter<String> {


    public CustomListAdapterPizza(Context context, ArrayList<String> values) {
        super(context, 0, values);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String pizzaInList = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pizza_list_layout, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textViewCustomPizza);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewCustomPizza);

        textView.setText(pizzaInList);
        imageView.setImageResource(R.drawable.pizza_image);

        return convertView;
    }


}


