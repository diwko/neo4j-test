package repository;

import model.Match;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends Neo4jRepository<Match, Long> {
}
