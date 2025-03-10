package org.example;

public class Main {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();

        Thread orderSimulator1 = new Thread(new OrderSimulator(stockExchange));
        Thread orderSimulator2 = new Thread(new OrderSimulator(stockExchange));
        Thread orderSimulator3 = new Thread(new OrderSimulator(stockExchange));

        orderSimulator1.start();
        orderSimulator2.start();
        orderSimulator3.start();

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        stockExchange.matchOrders();

        try {
            orderSimulator1.join();
            orderSimulator2.join();
            orderSimulator3.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
