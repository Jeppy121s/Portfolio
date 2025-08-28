package com.humber.Project01_GameStore.controllers;

import com.humber.Project01_GameStore.models.GameModel;
import com.humber.Project01_GameStore.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;


@RequestMapping("/games")
@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games" )
    public String getGames(Model model, @RequestParam(required = false) String msg,
                           @RequestParam(required = false) String searchedTitle) {

        if(searchedTitle != null){
            model.addAttribute("games", gameService.getFilteredGames(searchedTitle));
            model.addAttribute("msg","Items filtered successfully");
            return "games"; // Redirect back to the games page
        }

        List<GameModel> games = gameService.getGames();
        model.addAttribute("games", games);
        return "games"; // This corresponds to the name of your HTML file (games.html)
    }

    @GetMapping("/filtered-games/{searchedTitle}")
    public List<GameModel> getFilteredGames(@RequestParam String searchedTitle) {
       return gameService.getFilteredGames(searchedTitle);
    }

    @PostMapping("/addFavorites")
    public String addFavorites(@RequestParam("selectedGameIds") String selectedGameIds, Model model) {
        List<GameModel> favoriteGames = gameService.getGamesByIds(selectedGameIds);
        model.addAttribute("favorites", favoriteGames);
        return "favorites";
    }
    @GetMapping("/games/{gameId}")
    public GameModel getGameById(@PathVariable Integer gameId){
        return gameService.getGameById(gameId);

    }
//    @GetMapping("/favorites")
//    public String getFavorites(Model model) {
//        List<GameModel> favoriteGames = gameService.getAllFavoriteGames(); // Implement this method in GameService
//        model.addAttribute("favorites", favoriteGames);
//        return "favorites";
//    }
}