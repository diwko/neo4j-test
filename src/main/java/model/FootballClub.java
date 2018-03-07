package model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class FootballClub {
    @Id
    @GeneratedValue
    private Long FootballClubId;
    private String name;

    @Relationship(type = "TRAINS", direction = Relationship.INCOMING)
    private CoachContract coachContract;

    @Relationship(type = "PLAYS_FOR", direction = Relationship.INCOMING)
    private Set<FootballerContract> footballerContracts = new HashSet<>();

    @Relationship(type = "WON")
    private Set<Match> winnings = new HashSet<>();

    @Relationship(type = "DREW")
    private Set<Match> draws = new HashSet<>();

    @Relationship(type = "LOST")
    private Set<Match> losses = new HashSet<>();

    public FootballClub() {}

    public FootballClub(String name) {
        this.name = name;
    }

    public Long getFootballClubId() {
        return FootballClubId;
    }

    public String getName() {
        return name;
    }

    public CoachContract getCoachContract() {
        return coachContract;
    }

    public Set<FootballerContract> getFootballerContracts() {
        return footballerContracts;
    }

    public void setCoach(CoachContract coachContract) {
        this.coachContract = coachContract;
    }

    public void addFoorballer(FootballerContract footballerContract) {
        footballerContracts.add(footballerContract);
    }

    public Set<Match> getWinnings() {
        return winnings;
    }

    public Set<Match> getDraws() {
        return draws;
    }

    public Set<Match> getLosses() {
        return losses;
    }

    public void addWin(Match match) {
        winnings.add(match);
    }

    public void addDraw(Match match) {
        draws.add(match);
    }

    public void addLoss(Match match) {
        losses.add(match);
    }

    @Override
    public String toString() {
        return name;
    }
}
