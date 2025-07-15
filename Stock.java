public class Stock {
    String symbol, name;
    double price;

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public String toString() {
        return symbol + " - " + name + ": $" + price;
    }
}
