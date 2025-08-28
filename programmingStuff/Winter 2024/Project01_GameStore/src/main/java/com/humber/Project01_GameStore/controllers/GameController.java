package com.humber.Project01_GameStore.controllers;

import com.humber.Project01_GameStore.models.GameModel;
import com.humber.Project01_GameStore.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                           @RequestParam(required = false) String searchedTitle

    ) {

        if(searchedTitle != null){
           // model.addAttribute( "books", gameService.getFilteredGames(searchedTitle)); uncomment this when filtered games methoed is done in services
            model.addAttribute("msg","Items filtered successfully");
            return "catalogue";
        }

        List<GameModel> games = gameService.getGames();
        model.addAttribute("games", games);
        return "games"; // This corresponds to the name of your HTML file (games.html)
    }
}