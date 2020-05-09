package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    private CompositeAggregate compositeAggregate;

    public Finder(PrisonersDatabase prisonersDatabase, PersonDataProvider personDataProvider) {
        this.compositeAggregate = new CompositeAggregate();
        this.compositeAggregate.addChild(prisonersDatabase);
        this.compositeAggregate.addChild(personDataProvider);
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspects = new ArrayList<>();
        Iterator<Suspect> suspectIterator = this.compositeAggregate.iterator();

        while(suspectIterator.hasNext()){
            Suspect suspect = suspectIterator.next();
            if(suspect instanceof Prisoner){
                Prisoner prisoner = (Prisoner) suspect;
                if (!prisoner.isSuspicious() && prisoner.getName().equals(name)) {
                    suspects.add(prisoner);
                }
            }
            else if(suspect instanceof Person){
                Person person = (Person) suspect;
                if (person.getAge() > 18 && person.getName().equals(name)) {
                    suspects.add(person);
                }
            }
            if(suspects.size() >= 10) break;
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");

        for (Suspect suspect: suspects) {
            System.out.println(suspect.display());
        }

    }
}