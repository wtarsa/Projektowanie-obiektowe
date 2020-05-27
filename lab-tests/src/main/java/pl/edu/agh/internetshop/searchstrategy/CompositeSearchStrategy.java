package pl.edu.agh.internetshop.searchstrategy;

import pl.edu.agh.internetshop.Order;

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
    public boolean filter(Order order) {
        for(SearchStrategy strategy: strategies){
            if(!strategy.filter(order)) return false;
        }
        return true;
    }
}
