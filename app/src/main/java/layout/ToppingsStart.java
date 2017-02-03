package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geogehigbie.pizzabuilder.R;

import java.util.ArrayList;


public class ToppingsStart extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        addOnClickListeners();

        return inflater.inflate(R.layout.fragment_toppings_start, container, false);
    }

    private ArrayList<String> toppingsArrayList = new ArrayList<String>();

    private void addOnClickListeners(){
        Button done = (Button) getActivity().findViewById(R.id.toppingsDone);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, new ToppingsList());
            }
        });

        Button pepperoni = (Button) getActivity().findViewById(R.id.pepperoni);
        Button saussage = (Button) getActivity().findViewById(R.id.sausage);
        Button canadianBacon = (Button) getActivity().findViewById(R.id.canadian);
        Button bacon = (Button) getActivity().findViewById(R.id.bacon);
        Button hamburger = (Button) getActivity().findViewById(R.id.hamburger);
        Button chicken = (Button) getActivity().findViewById(R.id.chicken);
        Button saussage = (Button) getActivity().findViewById(R.id.sausage);

    }



}
