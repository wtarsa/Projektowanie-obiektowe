package pl.edu.agh.to.lab4;

import java.util.*;

public class FlatIterator implements Iterator {

    private static int index;
    private ArrayList<Suspect> prisoners;

    public FlatIterator(PrisonersDatabase prisonersDatabase){
        this.prisoners = getPrisoners(prisonersDatabase);
        FlatIterator.index = 0;
    }

    private ArrayList<Suspect> getPrisoners(PrisonersDatabase prisonersDatabase) {
        ArrayList<Suspect> prisoners = new ArrayList<>();
        Set<String> keys = prisonersDatabase.getAllPrisoners().keySet();
        for (String key : keys) {
            for (Suspect suspect : prisonersDatabase.getAllPrisoners().get(key)) {
                prisoners.add(suspect);
            }

        }
        return prisoners;
    }

    @Override
    public boolean hasNext() {
        return prisoners.size() >= (index+1);
    }

    @Override
    public Object next() {
        Prisoner prisoner = (Prisoner) prisoners.get(index);
        index++;
        return prisoner;
    }
}
