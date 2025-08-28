package com.example.SpringRestApp.repositories;

import com.example.SpringRestApp.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepositiory extends JpaRepository<Dish,Integer> {

    @Query("SELECT d FROM Dish d WHERE d.name= :name")
    Dish findDishByName(String name);
}
