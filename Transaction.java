import java.time.LocalDateTime;

public class Transaction {
    Stock stock;
    int quantity;
    double price;
    String type; // "BUY" or "SELL"
    LocalDateTime timestamp;

    public Transaction(Stock stock, int quantity, double price, String type, LocalDateTime timestamp) {
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return timestamp + " | " + type + " | " + stock.symbol + " | Qty: " + quantity + " | Price: $" + price;
    }
}
