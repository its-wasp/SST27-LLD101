public class CardPayment implements PaymentStrategy{

    public String pay(Payment payment){
        return "Charged card: " + payment.amount;
    }
}
