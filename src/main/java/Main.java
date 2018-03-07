
import model.FootballClub;
import model.Footballer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.FootballClubRepository;
import repository.FootballerRepository;
import service.DataPopulator;
import service.RelationsService;


public class Main {
    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
    public static void main(String [] args) {
        DataPopulator dataPopulator = context.getBean(DataPopulator.class);
        dataPopulator.populateData();

        RelationsService relationsService = context.getBean(RelationsService.class);
        System.out.println("Bayern relations:");
        FootballClubRepository clubRepository = context.getBean(FootballClubRepository.class);
        FootballClub bayern = clubRepository.findByName("Bayern Munich").get(0);
        relationsService.printAllRelations(bayern.getFootballClubId());


        System.out.println("Lewandowski->Hazard shortest path:");
        FootballerRepository footballerRepository = context.getBean(FootballerRepository.class);
        Footballer lewy = footballerRepository.findByName("Lewandowski Robert").get(0);
        Footballer hazard = footballerRepository.findByName("Hazard Eden").get(0);
        relationsService.printShortestPath(lewy.getFootballerId(), hazard.getFootballerId());
    }
}
