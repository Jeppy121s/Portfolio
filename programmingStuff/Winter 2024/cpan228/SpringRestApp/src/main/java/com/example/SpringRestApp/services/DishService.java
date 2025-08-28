package com.example.SpringRestApp.services;

import com.example.SpringRestApp.models.Dish;
import com.example.SpringRestApp.repositories.DishRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private final DishRepositiory dishRepositiory;

    @Autowired
    public DishService(DishRepositiory dishRepositiory){
        this.dishRepositiory=dishRepositiory;
    }

    //get all dishes
    public List<Dish> getAllDishes(){
        return dishRepositiory.findAll();
    }

    public Dish getDishById(int id){
        return dishRepositiory.findById(id).orElse(null);
    }

    public void addDish(Dish dish){
        Dish existingDish=this.dishRepositiory.findDishByName(dish.getName());
        if(existingDish!=null){
            throw new IllegalStateException("Dish already exists!");
        }
        dishRepositiory.save(dish);
    }

    public void updateDish(int dishId, Dish dish){
        boolean existsDish = this.dishRepositiory.existsById(dishId);

        if(!existsDish){
            throw new IllegalStateException("Dish with id " + dishId+
                    " Does not exist! Unable to update!");
        }

        dish.setId(dishId);
        dishRepositiory.save(dish);

    }
    public void deleteDish(int dishId, Dish dish){
        boolean existsDish = this.dishRepositiory.existsById(dishId);

        if(!existsDish){
            throw new IllegalStateException("Dish with id " + dishId+
                    " Does not exist! Unable to Delete!");
        }

        dishRepositiory.deleteById(dishId);

    }
}
