package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geogehigbie.pizzabuilder.R;

import java.util.ArrayList;


public class ToppingsStart extends Fragment {

    View view;
    private ArrayList<String> toppingsArrayList = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_toppings_start, container, false);


        addOnClickListenerDone();
        addOnClickListenerToppings();
        addCustomToppingListener();

        return view;
    }


    private void addOnClickListenerDone() {
        Button doneButton = (Button) view.findViewById(R.id.toppingsDone);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, new ToppingsList());
            }
        });
    }

     private void addOnClickListenerToppings() {
         Button pepperoni = (Button) view.findViewById(R.id.pepperoni);
         Button sausage = (Button) view.findViewById(R.id.sausage);
         Button canadianBacon = (Button)  view.findViewById(R.id.canadian);
         Button bacon = (Button)  view.findViewById(R.id.bacon);
         Button hamburger = (Button)  view.findViewById(R.id.hamburger);
         Button chicken = (Button)  view.findViewById(R.id.chicken);
         Button mushrooms = (Button)  view.findViewById(R.id.mushrooms);
         Button olives = (Button)  view.findViewById(R.id.olives);
         Button onions = (Button)  view.findViewById(R.id.onions);
         Button peppers = (Button)  view.findViewById(R.id.peppers);
         Button pineapple = (Button)  view.findViewById(R.id.pineapple);
         Button tomatoes = (Button)  view.findViewById(R.id.tomatoes);

         final Button[] buttons = {pepperoni, sausage, canadianBacon, bacon, hamburger, chicken,
                 mushrooms, olives, onions, peppers, pineapple, tomatoes};

         for (int i = 0; i < buttons.length; i++) {
             final int j = i;
             buttons[i].setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     String newTopping = buttons[j].getText().toString();
                     Toast.makeText(getContext(), newTopping + " was added to your pizza", Toast.LENGTH_SHORT).show();
                     toppingsArrayList.add(newTopping);
                 }
             });
         }
     }

    private void addCustomToppingListener(){
        Button customToppingAdd = (Button) view.findViewById(R.id.toppingsEnter);
        customToppingAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) getActivity().findViewById(R.id.toppingsEditText);
                String newCustomTopping = editText.getText().toString();
                Toast.makeText(getContext(), newCustomTopping + " was added to your pizza.", Toast.LENGTH_SHORT);
                toppingsArrayList.add(newCustomTopping);

            }
        });
    }


}
