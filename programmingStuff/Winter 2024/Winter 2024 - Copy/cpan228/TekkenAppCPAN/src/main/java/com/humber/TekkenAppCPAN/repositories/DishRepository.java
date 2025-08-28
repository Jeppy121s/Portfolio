package com.humber.TekkenAppCPAN.repositories;

import com.humber.TekkenAppCPAN.models.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishRepository {
    public static List<Dish> dishes=new ArrayList<>();

    static{
        dishes.add(Dish.builder().id(1).name("Chicken").category("Non veg").price(12.99).build());
        dishes.add(Dish.builder().id(2).name("Shwarma").category("Veg").price(13.99).build());
        dishes.add(Dish.builder().id(3).name("Pizza").category("Vegan").price(99.99).build());
        dishes.add(Dish.builder().id(4).name("Chicken Sandwitch").category("Non veg").price(12.99).build());


    }
    public static List<Dish> getDishes(){
        return dishes;
    };
}
