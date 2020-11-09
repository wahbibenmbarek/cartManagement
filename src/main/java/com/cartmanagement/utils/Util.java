package com.cartmanagement.utils;

import com.cartmanagement.cart.Product;

import java.util.Iterator;
import java.util.Map;

public class Util {

    /**
     * Compute the price of the cart
     * @param map
     * @return
     */
    public static double computePrice(Map<Product, Integer> map) {
        double price = 0;
        Iterator<Map.Entry<Product, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Product, Integer> entry = iterator.next();
            price += entry.getValue() * entry.getKey().getPrice();
        }
        return price;
    }


    /**
     * Compute nbr of article
     *
     * @param map
     * @return
     */
    public static int computeNbArticle(Map<Product, Integer> map) {
        int nbArticle = 0;
        Iterator<Map.Entry<Product, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Product, Integer> entry = iterator.next();
            nbArticle += entry.getValue();
        }
        return nbArticle;
    }
}
