package service;

import org.neo4j.cypher.internal.frontend.v2_3.ast.functions.Str;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.LoadStrategy;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RelationsService {
    @Autowired
    private SessionFactory sessionFactory;

    public void printAllRelations(Long id) {
        Session session = sessionFactory.openSession();
        Map<String, Long> bindings = new HashMap<>();
        bindings.put("id", id);

        String query =
                "MATCH (a)-[r]-(b) " +
                "WHERE ID(a) = $id " +
                "RETURN a, b, r, LABELS(a) AS aLabel, LABELS(b) AS bLabel, TYPE(r) as rType";

        Result res = session.query(query, bindings);

        StringBuilder builder = new StringBuilder();
        res.forEach(relation -> {
            builder.append(relation.get("a").toString())
                    .append("\t->\t")
                    .append(((String[])relation.get("aLabel"))[0])
                    .append("\t->\t")
                    .append(relation.get("r").toString())
                    .append(" \t->\t")
                    .append(relation.get("rType").toString())
                    .append(" \t->\t")
                    .append(((String[])relation.get("bLabel"))[0])
                    .append(" \t->\t")
                    .append(relation.get("b").toString())
                    .append("\n");
        });

        System.out.println(builder);
    }

    public void printShortestPath(Long idA, Long idB) {
        Session session = sessionFactory.openSession();
        Map<String, Long> bindings = new HashMap<>();
        bindings.put("idA", idA);
        bindings.put("idB", idB);

        String query =
                "MATCH path=shortestPath((a)-[*]-(b)) " +
                "WHERE ID(a) = $idA AND ID(b) = $idB " +
                "RETURN a, b, LABELS(a) AS aLabel, LABELS(b) AS bLabel, NODES(path) AS npath, RELS(path) AS rpath LIMIT 1";

        Result res = session.query(query, bindings);

        StringBuilder builder = new StringBuilder();

        for (Map<String, Object> path : res) {
            ArrayList<Object> nodes = (ArrayList<Object>) path.get("npath");
            ArrayList<Object> rels = (ArrayList<Object>) path.get("rpath");

            for (int i = 0; i < nodes.size(); i++) {
                builder.append(nodes.get(i).toString());
                if(i < nodes.size() - 1)
                    builder.append("\t->\t");

                if (i < rels.size()) {
                    builder.append(rels.get(i).toString().replaceAll("[\\W\\d]", ""))
                            .append("\t->\t")
                            .append(nodes.get(i+1).toString())
                            .append("\n");
                }
            }
        }

        System.out.println(builder);
    }
}
