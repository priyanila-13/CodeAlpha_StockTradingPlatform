import java.util.*;
public class Market {
    List<Stock> availableStocks = new ArrayList<>();

    public void addStock(Stock stock) {
        availableStocks.add(stock);
    }

    public void displayMarketData() {
        System.out.println("----- Market Data -----");
        for (Stock stock : availableStocks) {
            System.out.println(stock);
        }
    }

    public Stock findStockBySymbol(String symbol) {
        for (Stock stock : availableStocks) {
            if (stock.symbol.equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null;
    }
}
