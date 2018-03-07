package service;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.CoachRepository;
import repository.FootballClubRepository;
import repository.FootballerRepository;
import repository.MatchRepository;

import java.time.LocalDate;
import java.util.*;

@Component
public class DataPopulator {
    @Autowired
    private FootballClubRepository footballClubRepository;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private FootballerRepository footballerRepository;
    @Autowired
    private MatchRepository matchRepository;

    public void populateData() {
        String [] clubNames = {
                "Manchester City", "Manchester United", "Chelsea F.C.",
                "Tottenham Hotspur F.C.", "Bayern Munich", "Borussia Dortmund",
                "FC Barcelona", "Real Madrid", "PSG"
        };

        String [] coachNames = {
                "Pep Guardiola", "Jose Mourinho", "Antonio Conte",
                "Mauricio Pochettino", "Jupp Heynckes", "Peter Stöger",
                "Ernesto Valverde", "Zinédine Zidane", "Unai Emery"};

        String [][] footballerNames = {
                {"Aguero Sergio", "De Bruyne Kevin"},
                {"Ibrahimovic Zlatan", "Pogba Paul"},
                {"Hazard Eden", "Morata Alvaro"},
                {"Kane Harry", "Eriksen Christian"},
                {"Lewandowski Robert", "Neuer Manuel"},
                {"Aubameyang Pierre-Emerick", "Piszczek Łukasz"},
                {"Messi Lionel", "Suarez Luis"},
                {"Ronaldo Cristiano", "Kroos Toni"},
                {"Neymar", "Cavani Edinson"}
        };

        String [][] matches = {
                {"Bayern Munich", "PSG", "3", "1"},
                {"PSG", "Bayern Munich", "3", "0"},
                {"Borussia Dortmund", "Tottenham Hotspur F.C.", "1", "2"},
                {"Tottenham Hotspur F.C.", "Borussia Dortmund", "3", "1"},
                {"Tottenham Hotspur F.C.", "Real Madrid", "3", "1"},
                {"Real Madrid", "Tottenham Hotspur F.C.", "1", "1"},
                {"Real Madrid", "Borussia Dortmund", "3", "2"},
                {"Borussia Dortmund", "Real Madrid", "1", "3"},
                {"Manchester United", "Manchester City", "1", "2"},
                {"Manchester United", "Tottenham Hotspur F.C.", "1", "0"},
                {"Chelsea F.C.", "Manchester United", "1", "0"},
                {"Manchester City", "Tottenham Hotspur F.C.", "4", "1"},
                {"Chelsea F.C.", "Manchester City", "0", "1"},
                {"Tottenham Hotspur F.C.", "Chelsea F.C.", "1", "2"},
                {"Borussia Dortmund", "Bayern Munich", "1", "3"}
        };

        Map<String, FootballClub> clubs = new HashMap<>();
        for(int i = 0; i < clubNames.length; i++) {
            FootballClub club = new FootballClub(clubNames[i]);
            clubs.put(clubNames[i], club);
            footballClubRepository.save(club);

            Coach coach = new Coach(coachNames[i]);
            coachRepository.save(coach);

            club.setCoach(
                    new CoachContract(coach, club,
                            LocalDate.of(2017, 8, 1),
                            LocalDate.of(2018,8,1)));

            for(String footballerName : footballerNames[i]) {
                Footballer footballer = new Footballer(footballerName);
                footballerRepository.save(footballer);
                club.addFoorballer(
                        new FootballerContract(
                                footballer,
                                club,
                                LocalDate.of(2017, 8, 1),
                                LocalDate.of(2018,8,1)));
            }
        }

        for(String[] matchData : matches) {
            Match match = new Match(
                    clubs.get(matchData[0]),
                    clubs.get(matchData[1]),
                    LocalDate.of(2017, 8, 1),
                    Integer.valueOf(matchData[2]),
                    Integer.valueOf(matchData[3]));

            matchRepository.save(match);
        }
    }
}
