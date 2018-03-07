package repository;

import model.FootballClub;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballClubRepository extends Neo4jRepository<FootballClub, Long> {
    List<FootballClub> findByName(String name);
}
