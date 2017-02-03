package com.geogehigbie.pizzabuilder;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by georgehigbie on 2/2/17.
 */

public class CustomListAdapterToppings extends ArrayAdapter<String> {


    @NonNull
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.row_layout, parent, false);

        String item = getItem(position);

        TextView textView = (TextView) customView.findViewById(R.id.textViewCustom);
        ImageView imageView = (ImageView) customView.findViewById(R.id.imageViewCustom);

        textView.setText(item);
        imageView.setImageResource(R.drawable.pizza_image);

        return customView;
    }
}
