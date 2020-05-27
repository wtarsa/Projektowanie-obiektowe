package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import pl.edu.agh.internetshop.searchstrategy.CompositeSearchStrategy;
import pl.edu.agh.internetshop.searchstrategy.NameSearchStrategy;
import pl.edu.agh.internetshop.searchstrategy.OrderPriceSearchStrategy;
import pl.edu.agh.internetshop.searchstrategy.ProductNameSearchStrategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class SearchStrategyTest {

    private Address address1 = new Address("Kowalski", "Sezamkowa 1", "38-322", "Gorlice");
    private Address address2 = new Address("Nowak", "Lea 53", "30-049", "Kraków");
    private OrderDatabase odb;

    private void initDatabase(){
        odb = new OrderDatabase();
        Shipment shipment1 = new Shipment(address1, address2);
        Shipment shipment2 = new Shipment(address2, address1);

        Product product1 = new Product("Mleko", BigDecimal.valueOf(1.24), 0.13);
        Product product2 = new Product("Chleb", BigDecimal.valueOf(1.20), 0.13);
        Order order1 = new Order(Arrays.asList(product1, product2));
        order1.setDiscount(0.1);
        order1.setShipment(shipment1);
        odb.addOrder(order1);

        Product product3 = new Product("Banany", BigDecimal.valueOf(5), 0);
        Product product4 = new Product("Jabłka", BigDecimal.valueOf(2), 0);
        Order order2 = new Order(Arrays.asList(product3, product4));
        order2.setDiscount(0);
        order2.setShipment(shipment2);
        odb.addOrder(order2);
    }

    @Test
    public void getOrdersWithGivenRecipientName(){
        //given
        initDatabase();
        CompositeSearchStrategy strategy = new CompositeSearchStrategy();
        strategy.addStrategy(new NameSearchStrategy("Kowalski"));

        //when
        List<Order> filteredOrders = odb.ordersFilter(strategy);

        //then
        assertEquals(1, filteredOrders.size());
    }

    @Test
    public void getOrdersWithGivenProductName(){
        //given
        initDatabase();
        CompositeSearchStrategy strategy1 = new CompositeSearchStrategy();
        strategy1.addStrategy(new ProductNameSearchStrategy("Chleb"));

        CompositeSearchStrategy strategy2 = new CompositeSearchStrategy();
        strategy2.addStrategy(new ProductNameSearchStrategy("Chleb"));
        strategy2.addStrategy(new ProductNameSearchStrategy("Banany"));

        //when
        List<Order> filteredOrders1 = odb.ordersFilter(strategy1);
        List<Order> filteredOrders2 = odb.ordersFilter(strategy2);

        //then
        assertEquals(1, filteredOrders1.size());
        assertEquals(0, filteredOrders2.size());
    }

    @Test
    public void getOrdersWithGivenOrderPrice(){
        //given
        initDatabase();
        CompositeSearchStrategy strategy1 = new CompositeSearchStrategy();
        strategy1.addStrategy(new OrderPriceSearchStrategy(2.40, true));
        CompositeSearchStrategy strategy2 = new CompositeSearchStrategy();
        strategy2.addStrategy(new OrderPriceSearchStrategy(2.35, false));

        //when
        List<Order> filteredOrders1 = odb.ordersFilter(strategy1);
        List<Order> filteredOrders2 = odb.ordersFilter(strategy2);

        //then
        assertEquals(1, filteredOrders1.size());
        assertEquals(2, filteredOrders2.size());
    }

    @Test
    public void getOrdersWithDifferentParametersGiven(){
        //given
        initDatabase();
        CompositeSearchStrategy strategy1 = new CompositeSearchStrategy();
        strategy1.addStrategy(new NameSearchStrategy("Nowak"));
        strategy1.addStrategy(new ProductNameSearchStrategy("Chleb"));
        strategy1.addStrategy(new OrderPriceSearchStrategy(2.35, true));

        //when
        List<Order> filteredOrders1 = odb.ordersFilter(strategy1);

        //then
        assertEquals(1, filteredOrders1.size());
    }

}
