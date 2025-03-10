package org.example;

public class Order {
    String orderType;
    String ticker;
    int quantity;
    double price;

    public Order(String orderType, String ticker, int quantity, double price) {
        this.orderType = orderType;
        this.ticker = ticker;
        this.quantity = quantity;
        this.price = price;
    }
}

