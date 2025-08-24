import java.util.*;
public class PaymentStrategyRegistry {
    private static final Map<String, PaymentStrategy> strategies = new HashMap<>();
    static {
        strategies.put("CARD", new CardPayment());
        strategies.put("UPI", new UpiPayment());
        strategies.put("WALLET", new WalletPayment());
    }

    public static PaymentStrategy getPaymentStrategy(String paymentType){
        PaymentStrategy strategy = strategies.get(paymentType);
        if(strategy == null){
            throw new IllegalArgumentException("Unknown payment type: " + paymentType);

        }
        return strategy;
    }
}
