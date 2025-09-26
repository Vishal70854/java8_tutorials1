package org.example.exceptionHandling;

class Amount{
    private String currency;
    private int amount;

    public Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // CurrenciesDoNotMatchException is a checked exception that's why
    // it is handled in method signature using throws CurrenciesDoNotMatchException
    public void add(Amount that) throws CurrenciesDoNotMatchException {
        if(!this.currency.equals(that.currency)){
//            throw new Exception("Currencies don't match " + this.currency + " & " + that.currency);
            throw new CurrenciesDoNotMatchException("Currencies don't match " + this.currency + " & " + that.currency);
        }

        this.amount += that.amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}

// defining custom exception
// it is also a checked exception that means that it has to be thrown either in method signature or by using try-catch block
class CurrenciesDoNotMatchException extends Exception{
    public CurrenciesDoNotMatchException(String msg){
        super(msg);
    }
}

public class ThrowingExceptionRunner {
    // CurrenciesDoNotMatchException is a checked exception that's why
    // it is handled in method signature using throws CurrenciesDoNotMatchException
    public static void main(String[] args) throws CurrenciesDoNotMatchException {

        Amount amount1 = new Amount("USD",10);
        Amount amount2 = new Amount("INR",20);
        amount1.add(amount2);
        System.out.println(amount1);

    }
}
