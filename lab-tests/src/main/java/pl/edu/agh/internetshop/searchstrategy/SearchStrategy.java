package pl.edu.agh.internetshop.searchstrategy;

import pl.edu.agh.internetshop.Order;

public interface SearchStrategy {
    public boolean filter(Order order);
}
