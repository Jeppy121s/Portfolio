package com.humber.TekkenAppCPAN.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Dish {
    private int id;
    private String name;
    private String category;
    private Double price;


}
