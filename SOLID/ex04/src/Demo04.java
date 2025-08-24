
public class Demo04 {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        Payment p1 = new Payment("CARD", 150.0);
        Payment p2 = new Payment("UPI", 200.0);
        System.out.println("Processing card payment: " + paymentService.pay(p1));
        System.out.println("Processing UPI payment: " + paymentService.pay(p2));

    }
}
