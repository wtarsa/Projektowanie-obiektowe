package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.searchstrategy.CompositeSearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderDatabase {

    private List<Order> orders;

    public OrderDatabase(){
        this.orders = new ArrayList<Order>();
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public List<Order> getOrders(){
        return this.orders;
    }

    public List<Order> ordersFilter(CompositeSearchStrategy strategy){
        List<Order> filteredOrders = new ArrayList<>();
        for(Order order: this.orders){
            if(strategy.filter(order)) filteredOrders.add(order);
        }
        return filteredOrders;
    }

}
