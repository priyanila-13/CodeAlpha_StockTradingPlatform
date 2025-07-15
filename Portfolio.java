import java.util.*;
public class Portfolio {
    Map<Stock, Integer> holdings = new HashMap<>();

    public void addStock(Stock stock, int qty) {
        holdings.put(stock, holdings.getOrDefault(stock, 0) + qty);
    }

    public void removeStock(Stock stock, int qty) {
        if (holdings.containsKey(stock)) {
            int current = holdings.get(stock);
            if (qty >= current) {
                holdings.remove(stock);
            } else {
                holdings.put(stock, current - qty);
            }
        }
    }

    public double getPortfolioValue() {
        double total = 0;
        for (Map.Entry<Stock, Integer> entry : holdings.entrySet()) {
            total += entry.getKey().price * entry.getValue();
        }
        return total;
    }

    public void displayPortfolio() {
        System.out.println("----- Portfolio -----");
        for (Map.Entry<Stock, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey().symbol + " | Qty: " + entry.getValue() + " | Current Price: $" + entry.getKey().price);
        }
        System.out.println("Total Portfolio Value: $" + getPortfolioValue());
    }
}
