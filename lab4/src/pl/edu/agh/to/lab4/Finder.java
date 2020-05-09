package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    /*private final Collection<Suspect> allPersons;

    private final Map<String, Collection<Suspect>> allPrisoners;

    public Finder(Collection<Suspect> allPersons, Map<String, Collection<Suspect>> allPrisoners) {
        this.allPersons = allPersons;
        this.allPrisoners = allPrisoners;
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(personDataProvider.getAllCracowCitizens(), prisonersDatabase.getAllPrisoners());
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<Prisoner>();
        ArrayList<Person> suspectedPersons = new ArrayList<Person>();

        for (Collection<Suspect> prisonerCollection : allPrisoners.values()) {
            for (Suspect suspect : prisonerCollection) {
                Prisoner prisoner = (Prisoner) suspect;
                if (!prisoner.isSuspicious() && prisoner.getName().equals(name)) {
                    suspectedPrisoners.add(prisoner);
                }
                if (suspectedPrisoners.size() >= 10) {
                    break;
                }
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        if (suspectedPrisoners.size() < 10) {
            for (Suspect suspect : allPersons) {
                Person person = (Person) suspect;
                if (person.getAge() > 18 && person.getName().equals(name)) {
                    suspectedPersons.add(person);
                }
                if (suspectedPrisoners.size() + suspectedPersons.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspectedPrisoners.size() + suspectedPersons.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner n : suspectedPrisoners) {
            System.out.println(n.display());
        }

        for (Person p : suspectedPersons) {
            System.out.println(p.display());
        }
    }*/
    private final PrisonersDatabase prisonersDatabase;
    private final PersonDataProvider personDataProvider;

    public Finder(PrisonersDatabase prisonersDatabase, PersonDataProvider personDataProvider) {
        this.prisonersDatabase = prisonersDatabase;
        this.personDataProvider = personDataProvider;
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<Prisoner>();
        ArrayList<Person> suspectedPersons = new ArrayList<Person>();

        FlatIterator prisonersIterator = this.prisonersDatabase.iterator();
        while (prisonersIterator.hasNext()) {
            Prisoner prisoner = (Prisoner) prisonersIterator.next();
            if (!prisoner.isSuspicious() && prisoner.getName().equals(name)) {
                suspectedPrisoners.add(prisoner);
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        Iterator<Suspect> personIterator = this.personDataProvider.iterator();
        while (personIterator.hasNext()){
            Person person = (Person) personIterator.next();
            if (person.getAge() > 18 && person.getName().equals(name)) {
                suspectedPersons.add(person);
            }
            if (suspectedPrisoners.size() + suspectedPersons.size() >= 10) {
                break;
            }
        }

        int t = suspectedPrisoners.size() + suspectedPersons.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner n : suspectedPrisoners) {
            System.out.println(n.display());
        }

        for (Person p : suspectedPersons) {
            System.out.println(p.display());
        }
    }
}