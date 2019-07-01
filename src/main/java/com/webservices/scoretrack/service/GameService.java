package com.webservices.scoretrack.service;

import com.webservices.scoretrack.constants.AppConstants;
import com.webservices.scoretrack.domain.Game;
import com.webservices.scoretrack.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.GameDto;

import java.util.Date;
import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }


    public Game createNewGame(GameDto gameDto) {
        String gameId = gameDto.getTeam1() + AppConstants.GAMEID_SEPARATOR + gameDto.getTeam2();

        if(!(gameRepository.existsByGameId(gameId) &&
                gameRepository.existsByGameId(gameId))) {
            Game game = new Game();

            game.setGameId(gameId);
            game.setTeam1(gameDto.getTeam1());
            game.setTeam2(gameDto.getTeam2());
//        game.setGameDateTime(new DateTime());
            gameRepository.save(game);
        }

        return null;
    }

    public void createNewGames(List<GameDto>  gameDtoList) {

    }


    public Iterable<Game> lookup() {
        return gameRepository.findAll();
    }
}
