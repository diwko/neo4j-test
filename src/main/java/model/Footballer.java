package model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Footballer {
    @Id
    @GeneratedValue
    private Long footballerId;
    private String name;

    public Footballer() {}

    public Footballer(String name) {
        this.name = name;
    }

    public Long getFootballerId() {
        return footballerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
