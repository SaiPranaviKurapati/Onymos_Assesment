package org.example;

public class OrderSimulator implements Runnable {
    private final StockExchange stockExchange;

    public OrderSimulator(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    @Override
    public void run() {
        String[] tickers = {"AAPL", "GOOGL", "MSFT", "AMZN", "TSLA"};
        String[] orderTypes = {"Buy", "Sell"};
        int numOrders = 100;

        for (int i = 0; i < numOrders; i++) {
            String orderType = orderTypes[(int) (Math.random() * 2)];
            String ticker = tickers[(int) (Math.random() * tickers.length)];
            int quantity = (int) (Math.random() * 100) + 1;
            double price = Math.random() * 1000 + 100;

            stockExchange.addOrder(orderType, ticker, quantity, price);

            try {
                Thread.sleep((long) (Math.random() * 100));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
