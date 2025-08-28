package com.humber.TekkenAppCPAN.services;

import com.humber.TekkenAppCPAN.models.Dish;
import com.humber.TekkenAppCPAN.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    public List<Dish> getDishes(){
        return DishRepository.getDishes();
    }
}
