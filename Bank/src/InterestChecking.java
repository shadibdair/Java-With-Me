
// This class represents an interest-bearing checking account without a monthly service charge.
// It has a higher minimum balance requirement than a regular checking account.
// Monthly interest is credited based on the current balance.
public class InterestChecking extends NoServiceChargeChecking {
    private static final double DEFAULT_INTEREST_RATE = 0.02;  // Default interest rate of 2%
    private double interestRate;

    public InterestChecking(String accountNumber, String ownerName, String ownerId, double balance) {
        this(accountNumber, ownerName, ownerId, balance, DEFAULT_INTEREST_RATE);
    }

    public InterestChecking(String accountNumber, String ownerName, String ownerId, double balance, double interestRate) {
        super(accountNumber, ownerName, ownerId, balance);
        this.interestRate = interestRate;
    }


    @Override
    public void monthlyManagement() {
        double interest = super.getBalance() * interestRate;
        super.deposit(interest);
    }
}
