package com.humber.Project01_GameStore.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameModel {
    private int id; // Add id field
    private String slug;
    private String name;
    private String released; // Add released field
    private String backgroundImage; // Add backgroundImage field
    private double rating; // Add rating field
    private List<Platform> platforms;

    // Inner class representing platform object
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Platform {
        private PlatformDetail platform;
    }

    // Inner class representing platform detail
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlatformDetail {
        private int id;
        private String name;
        private String slug;
    }
}
