package com.example.Spring.Rest.Client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    private int id;
    private int userId;
    private String title;
}
