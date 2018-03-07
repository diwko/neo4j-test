package model;

import org.neo4j.ogm.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@NodeEntity
public class Match {
    @Id
    @GeneratedValue
    private Long matchId;
    @Relationship(type = "HOME_TEAM", direction = Relationship.OUTGOING)
    private FootballClub homeTeam;

    @Relationship(type = "AWAY_TEAM", direction = Relationship.OUTGOING)
    private FootballClub awayTeam;

    private LocalDate date;
    private Integer goalsHomeTeam;
    private Integer goalsAwayTeam;

    public Match() {}

    public Match(FootballClub homeTeam, FootballClub club2, LocalDate date) {
        this.homeTeam = homeTeam;
        this.awayTeam = club2;
        this.date = date;
    }

    public Match(FootballClub homeTeam, FootballClub awayTeam, LocalDate date, Integer goalsHomeTeam, Integer goalsAwayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
        updateFootballClubs();
    }

    public Long getMatchId() {
        return matchId;
    }

    public FootballClub getHomeTeam() {
        return homeTeam;
    }

    public FootballClub getAwayTeam() {
        return awayTeam;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setResult(Integer goalsHomeTeam, Integer goalsAwayTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
        updateFootballClubs();
    }

    public Optional<FootballClub> getWinner() {
        if(goalsHomeTeam.equals(goalsAwayTeam))
            return Optional.empty();
        return (goalsHomeTeam > goalsAwayTeam ? Optional.of(homeTeam):Optional.of(awayTeam));
    }

    private void updateFootballClubs() {
        if(goalsHomeTeam.equals(goalsAwayTeam)) {
            homeTeam.addDraw(this);
            awayTeam.addDraw(this);
        } else if(goalsHomeTeam.compareTo(goalsAwayTeam) > 0) {
            homeTeam.addWin(this);
            awayTeam.addLoss(this);
        } else {
            homeTeam.addLoss(this);
            awayTeam.addWin(this);
        }
    }

    @Override
    public String toString() {
        return goalsHomeTeam + ":" + goalsAwayTeam;
    }
}
