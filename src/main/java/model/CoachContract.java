package model;

import org.neo4j.ogm.annotation.*;

import java.time.LocalDate;

@RelationshipEntity(type = "TRAINS")
public class CoachContract {
    @Id
    @GeneratedValue
    private Long contractId;

    @StartNode
    private Coach coach;

    @EndNode
    private FootballClub footballClub;

    private LocalDate startDate;
    private LocalDate endDate;

    public CoachContract() {}

    public CoachContract(Coach coach, FootballClub footballClub, LocalDate startDate, LocalDate endDate) {
        this.coach = coach;
        this.footballClub = footballClub;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getContractId() {
        return contractId;
    }

    public Coach getCoach() {
        return coach;
    }

    public FootballClub getFootballClub() {
        return footballClub;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Coach Contract: " + contractId;
    }
}
