package model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Coach {
    @Id
    @GeneratedValue
    private Long coachId;
    private String name;

    public Coach() {}

    public Coach(String name) {
        this.name = name;
    }

    public Long getCoachId() {
        return coachId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
