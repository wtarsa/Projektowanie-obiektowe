package pl.edu.agh.internetshop.searchstrategy;

import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;

import java.util.List;

public class ProductNameSearchStrategy implements SearchStrategy {

    private String productName;

    public ProductNameSearchStrategy(String productName){
        this.productName = productName;
    }

    @Override
    public boolean filter(Order order) {
        List<Product> products = order.getProducts();
        for(Product product: products){
            if(product.getName().equals(productName)) return true;
        }
        return false;
    }
}
