# Onymos_Assesment

# Real-Time Stock Trading Engine

## Overview
This project implements a real-time stock trading engine for matching Buy and Sell orders with the following features:

- **addOrder Function**: Supports adding orders with parameters: 
  - Order Type (Buy/Sell)
  - Ticker Symbol
  - Quantity
  - Price  
  It ensures a limit of 1,024 unique tickers.

- **matchOrder Function**: Matches Buy and Sell orders efficiently in **O(n)** time complexity, ensuring that Buy prices are greater than or equal to the lowest Sell price.

- **Concurrency & Race Conditions**: Handles race conditions using **lock-free** data structures (`ConcurrentLinkedQueue`) to ensure thread-safe order handling when multiple threads modify the order book.

- **Random Order Simulation**: A wrapper simulates active stock transactions by generating random orders with different parameters (order type, ticker, quantity, and price).

## How It Works
1. The `addOrder` method allows placing Buy or Sell orders with specified parameters.
2. The `matchOrder` method matches the Buy and Sell orders based on price criteria and executes trades.
3. The system supports up to 1,024 tickers and handles concurrency with lock-free queues.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/SaiPranaviKurapati/Real-Time-Stock-Trading-Engine.git
