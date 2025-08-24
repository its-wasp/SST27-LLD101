public interface IOrderRepository {
    void saveOrder(String customerEmail, double subtotal);
}
