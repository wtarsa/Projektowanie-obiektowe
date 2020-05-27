package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);

	@Test
    public void testProductName() throws Exception{
        //given
    	double discount = 0.0;

        // when
        Product product = new Product(NAME, PRICE, discount);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception{
        //given
        double discount = 0.0;

        // when
        Product product = new Product(NAME, PRICE, discount);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void getProductPriceAfterDiscountWithRoundUp(){
	    //given
        double discount = 0.13;

        //when
        Product product = new Product(NAME, BigDecimal.valueOf(1.24), discount);

        //then
        assertBigDecimalCompareValue(product.getPrice(), BigDecimal.valueOf(1.08));
    }

    @Test
    public void getProductPriceAfterDiscountWithRoundDown() {
        //given
        double discount = 0.13;

        //when
        Product product = new Product(NAME, BigDecimal.valueOf(1.20), discount);

        //then
        assertBigDecimalCompareValue(product.getPrice(), BigDecimal.valueOf(1.04));
    }

}