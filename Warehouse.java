import java.util.*;

public class Warehouse {
    private String whId;
    private String location;
    private int capacity;
    private List<Item> inventory;

    public Warehouse(String whId, String location, int capacity) {
        this.whId = whId;
        this.location = location;
        this.capacity = capacity;
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public Item findItem(String sku) {
        for (Item i : inventory) {
            if (i.getSku().equalsIgnoreCase(sku)) return i;
        }
        return null;
    }

    public void receive(Item item, int qty) {
        item.receive(qty);
        if (!inventory.contains(item)) {
            inventory.add(item);
        }
    }

    public boolean pickPack(String sku, int qty) {
        Item i = findItem(sku);
        if (i != null) {
            return i.reduceStock(qty);
        }
        return false;
    }

    public void showInventory() {
        System.out.println("Warehouse " + whId + " Inventory:");
        for (Item i : inventory) {
            System.out.println(" - " + i);
        }
    }
}
