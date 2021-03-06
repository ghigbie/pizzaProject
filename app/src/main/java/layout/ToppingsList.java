package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.geogehigbie.pizzabuilder.CustomListAdapterToppings;
import com.geogehigbie.pizzabuilder.R;

import java.util.ArrayList;


public class ToppingsList extends Fragment {
    private ArrayList<String> toppingsArrayList;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_toppings_list, container, false);
        toppingsArrayList = getArguments().getStringArrayList("toppingsArraysList");

        setOnClickListener();

        ListView listView = (ListView) view.findViewById(R.id.toppingsListView);
        ListAdapter listAdapter = new CustomListAdapterToppings(getActivity().getApplicationContext(), toppingsArrayList);
        //below is a standard array adapter
        //ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, toppingsArrayList);
        listView.setAdapter(listAdapter);
        return view;
    }


    public void setOnClickListener(){
        Button button = (Button) view.findViewById(R.id.saveAndNamePizza);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PizzaSaveAndName pizzaSaveAndName = new PizzaSaveAndName();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("toppingsArrayList", toppingsArrayList);
                pizzaSaveAndName.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, pizzaSaveAndName);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

}
