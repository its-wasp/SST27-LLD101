public class OrderService implements IOrderService {
    IEmailClient email = new EmailClient();
    IOrderRepository orderRepository = new OrderRepository();
    double taxRate = 0.18;

    double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }

    @Override
    public void checkout(String customerEmail, double subtotal) {
        double total = totalWithTax(subtotal);
        String body = "Your order total is " + total;
        email.send(customerEmail, body);
        orderRepository.saveOrder(customerEmail, total);
    }
}