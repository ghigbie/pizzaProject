package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.geogehigbie.pizzabuilder.CustomListAdapterToppings;
import com.geogehigbie.pizzabuilder.R;

import java.util.ArrayList;


public class ToppingsList extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_toppings_list, container, false);


        ArrayList<String> toppingsArrayList = getArguments().getStringArrayList("toppingsArraysList");

        ListView listView = (ListView) view.findViewById(R.id.toppingsListView);
        ListAdapter listAdapter = new CustomListAdapterToppings(getActivity().getApplicationContext(), toppingsArrayList);
        listView.setAdapter(listAdapter);

        return view;
    }

}
