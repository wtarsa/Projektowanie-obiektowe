package pl.edu.agh.internetshop.searchstrategy;

import pl.edu.agh.internetshop.Order;

public class NameSearchStrategy implements SearchStrategy{

    private String name;

    public NameSearchStrategy(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Order order) {
        return order.getShipment().getRecipientAddress().getName().equals(name);
    }
}
