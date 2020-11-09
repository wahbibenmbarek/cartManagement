package com.cartmanagement.cart;

public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String myName, double myPrice, int myStock) {
        name = myName;
        price = myPrice;
        stock = myStock;
    }

    /**
     * will be used to increment the stock
     *
     * @param quantity
     */
    public void getFromStock(int quantity) {
        stock = stock - quantity;
    }

    /**
     * will be used to decrement the stock
     *
     * @param quantity
     */
    public void returnToStock(int quantity) {
        stock = stock + quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
