public class LogisticsService {
    public void processInbound(Warehouse wh, Item item, int qty) {
        wh.receive(item, qty);
        System.out.println("Inbound: Received " + qty + " of " + item.getName());
    }

    public void processOutbound(Warehouse wh, Shipment sh) {
        for (Item i : sh.items) {
            wh.pickPack(i.getSku(), 1);
        }
        sh.updateStatus("IN_TRANSIT");
        System.out.println("Outbound: Shipment " + sh + " dispatched.");
    }

    public void track(Shipment sh) {
        System.out.println("Tracking: " + sh);
    }

    public void bill(Shipment sh) {
        System.out.printf("Billing: Total cost for %s = $%.2f\n", sh, sh.calculateTotalCost());
    }
}
