public class Demo03 {
    public static void main(String[] args) {
        ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();
        Shipment s1 = new Shipment("EXPRESS", 2.0);
        Shipment s2 = new Shipment("STANDARD", 3.0);
        System.out.println("Shipping cost for EXPRESS 2.0kg: " + shippingCostCalculator.cost(s1));
        System.out.println("Shipping cost for STANDARD 3.0kg: " + shippingCostCalculator.cost(s2));
    }
}
