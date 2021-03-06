package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geogehigbie.pizzabuilder.ListOfPizzas;
import com.geogehigbie.pizzabuilder.Pizza;
import com.geogehigbie.pizzabuilder.R;

import java.util.ArrayList;


public class PizzaSaveAndName extends Fragment {
    private ArrayList<String> pizzaNamesArrayList = new ArrayList<String>();
    private ArrayList<String> toppingsArrayList;
    private ArrayList<Pizza> pizzaArrayList = new ArrayList<Pizza>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pizza_save_and_name, container, false);
        toppingsArrayList = getArguments().getStringArrayList("toppingsArrayList");
        setClickListener();


        return view;
    }

    public void setClickListener(){
        Button button = (Button) view.findViewById(R.id.enter_pizza_name_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPizzaName();
                buttonVisible();
            }
        });
    }

    public void getPizzaName() { //this method gets the pizza name and then creates a pizza object

        EditText editText = (EditText) view.findViewById(R.id.edit_text_pizza_name);
        String pizzaName;
        Pizza pizza;
        if (editText != null) {
            pizzaName = editText.getText().toString();
            pizzaNamesArrayList.add(pizzaName);
            pizza = new Pizza(pizzaName, toppingsArrayList);
            pizzaArrayList.add(pizza);
        } else {
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Please give this pizza a name.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buttonVisible(){
        Button button = (Button) view.findViewById(R.id.see_pizza_list);
        button.setVisibility(View.VISIBLE);
        setOnClickListenerOnInvisible();
    }

    public void setOnClickListenerOnInvisible(){
        Button button = (Button) view.findViewById(R.id.see_pizza_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ListOfPizzas.class);
                intent.putStringArrayListExtra("toppingsArrayList", toppingsArrayList);
                intent.putStringArrayListExtra("pizzaNamesArrayList", pizzaNamesArrayList);
//                intent.putExtra("pizzaArrayList", pizzaArrayList);
                startActivity(intent);
            }
        });

    }



}
