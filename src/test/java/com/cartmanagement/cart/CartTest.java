package com.cartmanagement.cart;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CartTest {


    Product p1, p2;
    Cart myCart;

    @Before
    public void setUp() throws Exception {
        //products initialisation
        p1 = new Product("TV", 56.4, 20);
        p2 = new Product("Bureau", 105.9, 20);
        //cart initialisation
        myCart = new Cart();
    }

    /**
     * Compute nmbr of article with one product
     *
     * @throws Exception
     */
    @Test
    public void testAddingOneProductOk() throws Exception {
        myCart.addProduct(p1, 3);
        Assertions.assertThat(myCart.nbOfArticle()).isEqualTo(3);
    }

    /**
     * Compute nmbr of article with multiple products
     *
     * @throws Exception
     */
    @Test
    public void testAddingMultipleProductOk() throws Exception {
        myCart.addProduct(p1, 3);
        myCart.addProduct(p2, 2);
        Assertions.assertThat(myCart.nbOfArticle()).isEqualTo(5);
    }

    /**
     * Compute price after adding multiple article
     *
     * @throws Exception
     */
    @Test
    public void testPriceWithMultipleProductOk() throws Exception {
        myCart.addProduct(p1, 3);
        myCart.addProduct(p2, 2);
        Assertions.assertThat(myCart.computePrice()).isEqualTo(381);
    }

    /**
     * Canceling some articles
     *
     * @throws Exception
     */
    @Test
    public void testcanCellingSomeProductProductOk() throws Exception {
        myCart.addProduct(p1, 3);
        myCart.addProduct(p2, 2);
        Assertions.assertThat(myCart.nbOfArticle()).isEqualTo(5);
        myCart.deleteProduct(p1, 1);
        Assertions.assertThat(myCart.nbOfArticle()).isEqualTo(4);
    }

    /**
     * Compute price after canceling some articles
     *
     * @throws Exception
     */
    @Test
    public void computePriceAfterCancellingSomeProductOk() throws Exception {
        myCart.addProduct(p1, 3);
        myCart.addProduct(p2, 2);
        Assertions.assertThat(myCart.nbOfArticle()).isEqualTo(5);
        myCart.deleteProduct(p1, 1);
        Assertions.assertThat(myCart.computePrice()).isEqualTo(324.6);
    }

    /**
     * Test stock after adding article
     *
     * @throws Exception
     */
    @Test
    public void testStockAfterAddingArticleOk() throws Exception {
        myCart.addProduct(p1, 3);
        myCart.addProduct(p2, 2);
        Assertions.assertThat(p1.getStock()).isEqualTo(17);
        Assertions.assertThat(p2.getStock()).isEqualTo(18);
    }

    /**
     * Test stock after cancelling article from cart
     *
     * @throws Exception
     */
    @Test
    public void testStockAfterCancellingFromCartOk() throws Exception {
        myCart.addProduct(p1, 3);
        myCart.addProduct(p2, 2);
        Assertions.assertThat(p1.getStock()).isEqualTo(17);
        Assertions.assertThat(p2.getStock()).isEqualTo(18);
        myCart.deleteProduct(p1, 2);
        myCart.deleteProduct(p2, 1);
        Assertions.assertThat(p1.getStock()).isEqualTo(19);
        Assertions.assertThat(p2.getStock()).isEqualTo(19);
    }


}
