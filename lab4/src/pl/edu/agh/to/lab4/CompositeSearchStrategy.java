package pl.edu.agh.to.lab4;

import java.util.ArrayList;

public class CompositeSearchStrategy implements SearchStrategy{

    private ArrayList<SearchStrategy> strategies;

    public CompositeSearchStrategy(){
        this.strategies = new ArrayList<>();
    }

    public void addStrategy(SearchStrategy strategy){
        this.strategies.add(strategy);
    }

    public void removeStrategy(SearchStrategy strategy){
        this.strategies.remove(strategy);
    }

    @Override
    public boolean filter(Suspect suspect) {
        for(SearchStrategy strategy: strategies){
            if(!strategy.filter(suspect)) return false;
        }
        return true;
    }
}
