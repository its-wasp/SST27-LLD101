public class StandardShipping implements ShippingStrategy{
    @Override
    public double calculate(Shipment shipment){
        return 50 + 5 * shipment.weightKg;
    }
}
