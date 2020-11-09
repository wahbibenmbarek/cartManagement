package com.cartmanagement.cart;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

    Product p1, p2;

    @Before
    public void setUp() throws Exception {
        p1 = new Product("TV", 56.4, 20);
        p2 = new Product("Bureau", 105.9, 20);
    }

    /**
     * Test stock when loading cart
     */
    @Test
    public void testGetFromStockOk() {
        p1.getFromStock(5);
        Assertions.assertThat(p1.getStock()).isEqualTo(15);
    }

    /**
     * Test stock when canceling product
     */
    @Test
    public void testReturnToStockOk() {
        p2.returnToStock(5);
        Assertions.assertThat(p2.getStock()).isEqualTo(25);
    }

}
