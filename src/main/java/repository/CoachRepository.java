package repository;

import model.Coach;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends Neo4jRepository<Coach, Long> {
    List<Coach> findByName(String name);
}
