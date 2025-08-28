package com.humber.Project01_GameStore.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.humber.Project01_GameStore.models.GameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final RestTemplate restTemplate;

    @Autowired
    public GameService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GameModel> getGames() {
        String apiUrl = "https://api.rawg.io/api/games?key=00140628493e4d7d8f60f0fb0c1560eb";

        // Make the request and retrieve the response
        ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {}
        );

        // Extract the "results" field from the response
        List<Map<String, Object>> results = (List<Map<String, Object>>) responseEntity.getBody().get("results");

        // Convert the "results" field to a list of GameModel objects
        List<GameModel> games = results.stream()
                .map(result -> {
                    GameModel game = new GameModel();
                    game.setId((Integer) result.get("id"));
                    game.setSlug((String) result.get("slug"));
                    game.setName((String) result.get("name"));
                    game.setReleased((String) result.get("released"));
                    game.setBackgroundImage((String) result.get("background_image"));
                    game.setRating((Double) result.get("rating"));
                    return game;
                })
                .collect(Collectors.toList());

        return games;


//    public List<GameModel> getFilteredGames(String searchedTitle) {
//      Return by filtering games from the api by name. I couldn't figure out how to do this but it's needed.
//    }
}}

