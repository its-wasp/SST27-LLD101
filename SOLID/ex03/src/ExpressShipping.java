public class ExpressShipping implements ShippingStrategy{
    @Override
    public double calculate(Shipment shipment){
        return 80 + 8 * shipment.weightKg;
    }
}
