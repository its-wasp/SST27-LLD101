public class WalletPayment implements PaymentStrategy{

    public String pay(Payment payment){
        return "Wallet debit: " + payment.amount;
    }
}
