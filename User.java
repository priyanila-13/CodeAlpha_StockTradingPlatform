import java.util.*;
import java.time.LocalDateTime;

public class User {
    String name;
    double balance;
    Portfolio portfolio = new Portfolio();
    List<Transaction> transactions = new ArrayList<>();

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void buyStock(Stock stock, int qty) {
        double cost = stock.price * qty;
        if (balance >= cost) {
            balance -= cost;
            portfolio.addStock(stock, qty);
            transactions.add(new Transaction(stock, qty, stock.price, "BUY", LocalDateTime.now()));
            System.out.println("Purchased " + qty + " shares of " + stock.symbol);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void sellStock(Stock stock, int qty) {
        if (portfolio.holdings.getOrDefault(stock, 0) >= qty) {
            double revenue = stock.price * qty;
            balance += revenue;
            portfolio.removeStock(stock, qty);
            transactions.add(new Transaction(stock, qty, stock.price, "SELL", LocalDateTime.now()));
            System.out.println("Sold " + qty + " shares of " + stock.symbol);
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public void viewTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("----- Transaction History -----");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
