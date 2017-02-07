package com.geogehigbie.pizzabuilder;

import java.util.ArrayList;

/**
 * Created by georgehigbie on 2/6/17.
 */

public class Pizza {

    String name;
    ArrayList listOfToppings;

    public Pizza(String name, ArrayList listOfToppings){
        this.name = name;
        this.listOfToppings = listOfToppings;
    }

    public ArrayList getListOfToppings() {
        return listOfToppings;
    }

    public void setListOfToppings(ArrayList listOfToppings) {
        this.listOfToppings = listOfToppings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
