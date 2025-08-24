
public class PaymentService {

    String pay(Payment payment){
        PaymentStrategy strategy = PaymentStrategyRegistry.getPaymentStrategy(payment.provider);
        return strategy.pay(payment);
    }
}