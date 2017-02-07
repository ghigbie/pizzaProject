package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.geogehigbie.pizzabuilder.CustomListAdapterPizza;
import com.geogehigbie.pizzabuilder.R;

import java.util.ArrayList;

public class PizzaList extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pizza_list, container, false);

        ArrayList<String> pizzaArrayList = getArguments().getStringArrayList("pizzaArraysList");
        ListView listView = (ListView) view.findViewById(R.id.pizzaListView);
        ListAdapter listAdapter = new CustomListAdapterPizza(getActivity().getApplicationContext(), pizzaArrayList);

        listView.setAdapter(listAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    public void setOnClickListener(){
        Button button = (Button) view.findViewById(R.id.)

    }

}
