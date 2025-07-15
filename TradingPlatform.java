import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

public class TradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();
        market.addStock(new Stock("AAPL", "Apple Inc.", 150));
        market.addStock(new Stock("GOOGL", "Alphabet Inc.", 2800));
        market.addStock(new Stock("TSLA", "Tesla Inc.", 700));

        User user = new User("Alice", 10000);

        while (true) {
            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.println("6. View Transaction History");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    market.displayMarketData();
                    break;
                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = sc.next();
                    Stock buyStock = market.findStockBySymbol(buySymbol);
                    if (buyStock != null) {
                        System.out.print("Enter quantity to buy: ");
                        int qty = sc.nextInt();
                        user.buyStock(buyStock, qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = sc.next();
                    Stock sellStock = market.findStockBySymbol(sellSymbol);
                    if (sellStock != null) {
                        System.out.print("Enter quantity to sell: ");
                        int qty = sc.nextInt();
                        user.sellStock(sellStock, qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 4:
                    user.portfolio.displayPortfolio();
                    System.out.println("Available Balance: $" + user.balance);
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    sc.close();
                    return;
                case 6:
                    user.viewTransactionHistory();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
