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
 * Created by georgehigbie on 2/1/17.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    public CustomListAdapter(Context context, String[] values) {
        super(context, R.layout.row_layout, values);


        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View customView = layoutInflater.inflate(R.layout.row_layout_for_use, parent, false);

            String item = getItem(position);

            TextView textView = (TextView) customView.findViewById(R.id.row_text_view);
            ImageView imageView = (ImageView) customView.findViewById(R.id.video_icon);

            textView.setText(item);
            imageView.setImageResource(R.drawable.video_icon_second);

            return customView;

        }
}

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.row_layout, parent, false);

        String item = getItem(position);

        TextView textView = (TextView) customView.findViewById(R.id.row_layout)
    }
        return super.getDropDownView(position, convertView, parent);
    }
