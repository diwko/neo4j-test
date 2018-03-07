package model;

import org.neo4j.ogm.annotation.*;

import java.time.LocalDate;


@RelationshipEntity(type = "PLAYS_FOR")
public class FootballerContract {
    @Id
    @GeneratedValue
    private Long contractId;

    @StartNode
    private Footballer footballer;

    @EndNode
    private FootballClub footballClub;

    private LocalDate startDate;
    private LocalDate endDate;

    public FootballerContract() {}

    public FootballerContract(Footballer footballer, FootballClub footballClub, LocalDate startDate, LocalDate endDate) {
        this.footballer = footballer;
        this.footballClub = footballClub;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getContractId() {
        return contractId;
    }

    public Footballer getFootballer() {
        return footballer;
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
        return "Footballer Contract: " + contractId;
    }
}
