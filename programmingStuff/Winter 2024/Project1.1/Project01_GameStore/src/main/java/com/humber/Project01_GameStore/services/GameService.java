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
    public List<GameModel> getFilteredGames(String searchedTitle) {
        String apiUrl = "https://api.rawg.io/api/games?key=dd7d3386ac704b4e842e48f7bed3ddec&search=" + searchedTitle;

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
    }




    public List<GameModel> getGames() {
        String apiUrl = "https://api.rawg.io/api/games?key=dd7d3386ac704b4e842e48f7bed3ddec";

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




}


    public List<GameModel> getGamesByIds(String selectedGameIds) {
        List<Integer> gameIdList = List.of(selectedGameIds.split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // Fetch games by IDs
        return gameIdList.stream()
                .map(this::getGameById)
                .collect(Collectors.toList());
    }

    private GameModel getGameById(Integer gameId) {
        // Implement a method to fetch a single game by ID from the API
        // Make HTTP request to fetch game details by ID
        // Convert API response to GameModel object and return
        // This method is just a placeholder; implement according to your API response structure
        return null;
    }


}

