public class ShippingCostCalculator {
    public double cost(Shipment shipment){
        ShippingStrategy strategy = ShippingStrategyRegistry.getStrategy(shipment.type);
        return strategy.calculate(shipment);
    }
}
