package com.webservices.scoretrack.controller;

import com.webservices.scoretrack.domain.Game;
import com.webservices.scoretrack.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.GameDto;
import web.GameDtoList;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/games")
public class GameController {
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    protected GameController() {

    }

    /**
     * Get the list of all games.
     **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getAllGames() {
        List<Game> allGames = gameService.getAllGames();
        return allGames;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewGame(@RequestBody @Validated GameDto gameDto){

        gameService.createNewGame(gameDto);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewGame(@RequestBody @Validated GameDtoList gameDtos){

        gameService.createNewGames(gameDtos.getGameDtoList());
    }





    @RequestMapping(value = "/talk", method = RequestMethod.GET)
    public String talk() {
        return "Hello from Simple Controller";
    }
}
