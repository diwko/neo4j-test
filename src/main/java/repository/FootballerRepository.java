package repository;

import model.Footballer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballerRepository extends Neo4jRepository<Footballer, Long> {
    List<Footballer> findByName(String name);
}
