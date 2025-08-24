public class UpiPayment implements PaymentStrategy{

    public String pay(Payment payment){
        return "Paid via UPI: " + payment.amount;
    }
}
