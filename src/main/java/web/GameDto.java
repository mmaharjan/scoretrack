package web;

import com.webservices.scoretrack.domain.Game;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GameDto {

    @NotNull
    @Size(max = 35)
    private String teamOne;

    @NotNull
    @Size(max = 35)
    private String teamTwo;

    //@NotNull
    private String gameGroup;

    public GameDto() {}

    public GameDto(String teamOne, String teamTwo, String gameGroup) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.gameGroup = gameGroup;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getGameGroup() {
        return gameGroup;
    }

    public void setGameGroup(String gameGroup) {
        this.gameGroup = gameGroup;
    }
}
