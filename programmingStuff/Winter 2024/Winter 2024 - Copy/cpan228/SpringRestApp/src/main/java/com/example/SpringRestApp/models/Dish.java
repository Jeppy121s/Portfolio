package com.example.SpringRestApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    @Embedded
    private Cuisine cuisine;

    //relationship with category
    @ManyToOne
    @JoinColumn(name="fk_category_id")
    //private Category category;
    //when saving a dish record it will also save a category record
    //will not delete category record if dish record is deleted
    //changes or updates to the dish record will not affect the category record
    @Cascade(CascadeType.PERSIST)
    private Category category;
}
