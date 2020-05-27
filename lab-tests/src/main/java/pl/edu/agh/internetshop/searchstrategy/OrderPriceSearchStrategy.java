package pl.edu.agh.internetshop.searchstrategy;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class OrderPriceSearchStrategy implements SearchStrategy{

    private BigDecimal orderPrice;
    private boolean cheaper;

    public OrderPriceSearchStrategy(double price, boolean cheaper){
        this.orderPrice = BigDecimal.valueOf(price);
        this.cheaper = cheaper;
    }

    @Override
    public boolean filter(Order order) {
        if(cheaper && order.getPriceWithTaxes().compareTo(orderPrice) <= 0) return true;
        else if(!cheaper && order.getPriceWithTaxes().compareTo(orderPrice) >= 0) return true;
        return false;
    }
}
