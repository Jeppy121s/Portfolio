package com.example.SpringRestApp.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable //allows class to be embedded into a different class
public class Cuisine {
    private String cuisineName;
    private String country;
}
