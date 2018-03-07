import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"repository", "model", "service"})
@EnableNeo4jRepositories("repository")
@EnableTransactionManagement
public class PersistenceContext {

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return  new org.neo4j.ogm.config.Configuration.Builder().build();
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "model");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}