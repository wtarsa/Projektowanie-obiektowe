package pl.edu.agh.to.lab4;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Finder suspects = new Finder();
        suspects.addDataProvider(new PrisonersDatabase());
        suspects.addDataProvider(new PersonDataProvider());
        suspects.addDataProvider(new StudentDataProvider());
//        suspects.displayAllSuspectsWithName("Janusz");

        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(new AgeSearchStrategy(22));
   //     searchStrategy.addStrategy(new NameSearchStrategy("Janusz"));
        ArrayList<Suspect> searchSuspects = (ArrayList<Suspect>) suspects.display(searchStrategy);
        for(Suspect suspect: searchSuspects){
            System.out.println(suspect.getName() + " " + suspect.getSurname());
        }

    }
}
