public class OvernightShipping implements ShippingStrategy{
    @Override
    public double calculate(Shipment shipment){
        return 120 + 10 * shipment.weightKg;
    }
}
