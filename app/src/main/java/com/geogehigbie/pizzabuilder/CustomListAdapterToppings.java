package com.geogehigbie.pizzabuilder;

import android.content.Context;
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

    public CustomListAdapterToppings(Context context, String[] values){
        super(context, R.layout.topping_list_layout, values);
    }

    @NonNull
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.topping_list_layout, parent, false);

        String item = getItem(position);

        TextView textView = (TextView) customView.findViewById(R.id.textViewCustomToppings);
        ImageView imageView = (ImageView) customView.findViewById(R.id.imageViewCustomToppings);

        textView.setText(item);
        imageView.setImageResource(R.drawable.mushroom);

        return customView;
    }
}
