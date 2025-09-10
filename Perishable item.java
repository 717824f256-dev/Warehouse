public class PerishableItem extends Item {
    private int shelfLifeDays;

    public PerishableItem(String sku, String name, double unitPrice, int qtyOnHand, int shelfLifeDays) {
        super(sku, name, unitPrice, qtyOnHand);
        this.shelfLifeDays = shelfLifeDays;
    }

    @Override
    public double shippingCost(double weight) {
        return super.shippingCost(weight) + 5.0;
    }

    @Override
    public String toString() {
        return super.toString() + " [Perishable, Shelf life=" + shelfLifeDays + " days]";
    }
}
