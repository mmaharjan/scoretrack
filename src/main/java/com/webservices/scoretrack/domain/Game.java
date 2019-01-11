package com.webservices.scoretrack.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Size(max = 7)
    private String gameId;

    @NotNull
    @Column
    @Size(max = 35)
    private String team1Code;

    @NotNull
    @Column
    @Size(max = 35)
    private String team2Code;

    @NotNull
    @Column
    private Date gameDatetime;
    // add group as well so that we can find out easily which group this game belongs to

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getTeam1() {
        return team1Code;
    }

    public void setTeam1(String team1Code) {
        this.team1Code = team1Code;
    }

    public String getTeam2() {
        return team2Code;
    }

    public void setTeam2(String team2Code) {
        this.team2Code = team2Code;
    }

    public Date getGameDatetime() {
        return gameDatetime;
    }

    public void setGameDateTime(Date gameDate) {
        this.gameDatetime = gameDate;
    }
}
