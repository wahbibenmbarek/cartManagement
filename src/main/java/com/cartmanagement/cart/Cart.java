package com.cartmanagement.cart;

import com.cartmanagement.utils.Util;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> map;

    public Cart() {
        map = new HashMap<>();
    }

    /**
     * add new product
     *
     * @param product
     * @param quantity
     * @throws Exception
     */
    public void addProduct(Product product, int quantity) throws Exception {
        if (product == null)
            throw new Exception();

        int initQuantity = 0;
        if (map.containsKey(product)) {
            initQuantity = map.get(product);
        }

        product.getFromStock(quantity);
        quantity += initQuantity;
        map.put(product, quantity);
    }

    /**
     * delete product from cart
     *
     * @param product
     * @param quantity
     * @throws Exception
     */
    public void deleteProduct(Product product, int quantity) throws Exception {
        if (product == null)
            throw new Exception();

        int initQuantity = 0;

        if (map.containsKey(product)) {
            initQuantity = map.get(product);
        }

        if (initQuantity < quantity)
            throw new Exception();

        product.returnToStock(quantity);
        initQuantity -= quantity;

        map.put(product, initQuantity);
    }

    /**
     * Compute the global price of the cart
     *
     * @return
     */
    public double computePrice() {
        return Util.computePrice(map);

    }

    /**
     * Compute the nb of the article
     *
     * @return
     */
    public int nbOfArticle() {
        return Util.computeNbArticle(map);

    }

    public Map<Product, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Product, Integer> map) {
        this.map = map;
    }
}
