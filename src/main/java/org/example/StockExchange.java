package org.example;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashSet;
import java.util.Set;

public class StockExchange {
    private final ConcurrentLinkedQueue<Order> buyOrders = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Order> sellOrders = new ConcurrentLinkedQueue<>();
    private final Set<String> tickers = new HashSet<>();
    private static final int max_tickers = 1024;

    public void addOrder(String orderType, String ticker, int quantity, double price) {

        if (tickers.size() >= max_tickers && !tickers.contains(ticker)) {
            System.out.println("Cannot add order. Limit of 1,024 tickers reached.");
            return;
        }

        tickers.add(ticker);

        Order order = new Order(orderType, ticker, quantity, price);
        if ("Buy".equals(orderType)) {
            buyOrders.offer(order);
        }
        else if ("Sell".equals(orderType)) {
            sellOrders.offer(order);
        }
        else {
            throw new IllegalArgumentException("Invalid order type");
        }
    }

    public void matchOrders() {
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            Order buyOrder = buyOrders.peek();
            Order sellOrder = sellOrders.peek();

            if (buyOrder.price >= sellOrder.price) {
                int quantity = Math.min(buyOrder.quantity, sellOrder.quantity);
                System.out.println("Matched Buy Order" + quantity + " " + buyOrder.ticker + " at " + buyOrder.price);
                System.out.println("Matched Sell Buy" + quantity + " " + sellOrder.ticker + " at " + sellOrder.price);

                buyOrder.quantity -= quantity;
                sellOrder.quantity -= quantity;

                if (buyOrder.quantity == 0) {
                    buyOrders.poll();
                }
                if (sellOrder.quantity == 0) {
                    sellOrders.poll();
                }
            }
            else {
                break;
            }
        }
    }
}
