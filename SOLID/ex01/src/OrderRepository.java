public class OrderRepository implements IOrderRepository {
    @Override
    public void saveOrder(String customerEmail, double total) {
        System.out.println("Order stored for " + customerEmail + " with total " + total + " (pretend DB).");
    }
}
