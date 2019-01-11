package com.webservices.scoretrack.controller;

import com.webservices.scoretrack.domain.Game;
import com.webservices.scoretrack.repo.GameGroupRepository;
import com.webservices.scoretrack.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.GameDto;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/games")
public class GameController {
    private GameGroupRepository gameGroupRepository;
    private GameRepository gameRepository;

    @Autowired
    public GameController(GameGroupRepository gameGroupRepository, GameRepository gameRepository) {
        this.gameGroupRepository = gameGroupRepository;
        this.gameRepository = gameRepository;
    }

    protected GameController() {

    }

    /**
     * Get the list of all games.
     **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getAllGames() {
        System.out.println("hello brother");
        List<Game> allGames = gameRepository.findAll();
        return allGames;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewGame(@RequestBody @Validated GameDto gameDto){
        Game game = new Game();
        if(gameDto.getTeamOne() != null && gameDto.getTeamOne() != null) {
            game.setGameId(gameDto.getTeamOne() + "_" + gameDto.getTeamTwo());
            game.setTeam1(gameDto.getTeamOne());
            game.setTeam2(gameDto.getTeamTwo());
            game.setGameDateTime(new Date());
        }

        gameRepository.save(game);
    }





    @RequestMapping(value = "/talk", method = RequestMethod.GET)
    public String talk() {
        return "Hello from Simple Controller";
    }
}
