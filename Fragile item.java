public class FragileItem extends Item {
    private double fragileHandlingFee;

    public FragileItem(String sku, String name, double unitPrice, int qtyOnHand, double fragileHandlingFee) {
        super(sku, name, unitPrice, qtyOnHand);
        this.fragileHandlingFee = fragileHandlingFee;
    }

    @Override
    public double shippingCost(double weight) {
        return super.shippingCost(weight) + fragileHandlingFee;
    }

    @Override
    public String toString() {
        return super.toString() + " [Fragile]";
    }
}
