public class Item {
    private String sku;
    private String name;
    private double unitPrice;
    private int qtyOnHand;

    public Item(String sku, String name, double unitPrice, int qtyOnHand) {
        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public double getUnitPrice() { return unitPrice; }
    public int getQtyOnHand() { return qtyOnHand; }
    public void setQtyOnHand(int qtyOnHand) { this.qtyOnHand = qtyOnHand; }

    public void receive(int qty) {
        this.qtyOnHand += qty;
    }

    public boolean reduceStock(int qty) {
        if (qtyOnHand >= qty) {
            qtyOnHand -= qty;
            return true;
        }
        return false;
    }

    public double shippingCost(double weight) {
        return weight * 2.0;
    }

    public double shippingCost(double weight, double distance, boolean priority) {
        double base = weight * 2.0 + distance * 0.5;
        return priority ? base * 1.5 : base;
    }

    public String toString() {
        return String.format("%s (%s): $%.2f, Qty=%d", name, sku, unitPrice, qtyOnHand);
    }
}
