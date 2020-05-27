package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
	
    private final String name;
    private final BigDecimal price;
    private final double discount; // has to be a number from the range <0.0, 1.0>

    public Product(String name, BigDecimal price, double discount) {
        this.name = name;
        this.discount = discount;
        this.price = price.multiply(BigDecimal.valueOf(1-discount)).setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}