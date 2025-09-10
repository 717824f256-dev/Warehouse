import java.util.*;

public class Shipment {
    private String shipId;
    private String destination;
    List<Item> items;
    private String status;
    private String carrier;

    public Shipment(String shipId, String destination, String carrier) {
        this.shipId = shipId;
        this.destination = destination;
        this.carrier = carrier;
        this.status = "CREATED";
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Item i : items) {
            total += i.shippingCost(10);
        }
        return total;
    }

    public String toString() {
        return "Shipment " + shipId + " to " + destination + " [" + status + "], Carrier=" + carrier;
    }

    public void printItems() {
        System.out.println("Shipment " + shipId + " Items:");
        for (Item i : items) {
            System.out.println(" - " + i);
        }
    }
}
