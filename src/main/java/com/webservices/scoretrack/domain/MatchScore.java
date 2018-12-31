package com.webservices.scoretrack.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="match_score")
public class MatchScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private Team team;

    @NotNull
    @Column
    private Integer score;

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
