package web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

public class GameDto {

    @NotNull
    @Size(max = 35)
    private String team1;

    @NotNull
    @Size(max = 35)
    private String team2;

    //@NotNull
    private String gameGroup;

    @NotNull
    private ZonedDateTime gameDateTime;

    public GameDto() {}

    public GameDto(String teamOne, String team2, String gameGroup) {
        this.team1 = teamOne;
        this.team2 = team2;
        this.gameGroup = gameGroup;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getGameGroup() {
        return gameGroup;
    }

    public void setGameGroup(String gameGroup) {
        this.gameGroup = gameGroup;
    }

    public ZonedDateTime getGameDateTime() {
        return gameDateTime;
    }

    public void setGameDateTime(ZonedDateTime gameDateTime) {
        this.gameDateTime = gameDateTime;
    }
}
