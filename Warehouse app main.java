public class WarehouseAppMain {
    public static void main(String[] args) {
        Warehouse wh = new Warehouse("WH01", "Chennai", 100);

        Item tv = new FragileItem("SKU101", "LED TV", 450.0, 10, 20.0);
        Item apple = new PerishableItem("SKU202", "Apple", 2.0, 50, 7);

        LogisticsService service = new LogisticsService();

        service.processInbound(wh, tv, 5);
        service.processInbound(wh, apple, 20);

        wh.showInventory();

        Shipment sh1 = new Shipment("SHIP01", "Bangalore", "BlueDart");
        sh1.addItem(tv);
        sh1.addItem(apple);

        service.processOutbound(wh, sh1);
        service.track(sh1);

        sh1.updateStatus("DELIVERED");
        service.track(sh1);

        service.bill(sh1);

        wh.showInventory();
    }
}
