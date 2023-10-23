// This abstract class represents a checking account that allows check-writing.
// It provides a method to write a check which may throw an IllegalBalance exception if there are insufficient funds.
public abstract class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, String ownerName, String ownerId, double balance) {
        super(accountNumber, ownerName, ownerId, balance);
    }

    // Writes a check for a given amount. Throws an IllegalBalance exception if there are insufficient funds.
    public void writeCheck(double amount) throws IllegalBalance {
        super.withdraw(amount);
    }
}
