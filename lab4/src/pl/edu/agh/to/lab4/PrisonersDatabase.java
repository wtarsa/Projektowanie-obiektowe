package pl.edu.agh.to.lab4;

import java.util.*;

public class PrisonersDatabase implements SuspectAggregate{

    private final Map<String, ArrayList<Suspect>> prisoners = new HashMap<String, ArrayList<Suspect>>();

    public PrisonersDatabase() {
        addPrisoner("Wiezienie krakowskie", new Prisoner("Jan", "Kowaglski", "90080452357", 2005, 7));
        addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", "98080452357", 2009, 3));
        addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", "92080445657", 2001, 10));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety", "802104543357", 2010, 5));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Adam", "Future", "880216043357", 2020, 5));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Zbigniew", "Nienajedzony", "90051452335", 2011, 1));
        addPrisoner("Wiezienie centralne", new Prisoner("Jan", "Przedziwny", "91103145223", 2009, 4));
        addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", "85121212456", 2012, 1));
    }

    public Map<String, ArrayList<Suspect>> getAllPrisoners() {
        return prisoners;
    }

    public Collection<String> getAllPrisons() {
        return prisoners.keySet();
    }

    public void addPrisoner(String category, Prisoner prisoner) {
        if (!prisoners.containsKey(category))
            prisoners.put(category, new ArrayList<Suspect>());
        prisoners.get(category).add(prisoner);
    }

    @Override
    public Iterator iterator() {
        return new FlatIterator(this);
    }

    public String getPrison(Prisoner prisoner){
        Set<String> keySet = this.prisoners.keySet();
        for(String key: keySet){
            if(this.prisoners.get(key).equals(prisoner)) return key;
        }
        return null;
    }
}
