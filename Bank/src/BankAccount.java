
 // This abstract class represents a generic bank account.
 // It holds common properties like account number, owner name, ID, and balance.
 // Methods are provided to deposit and withdraw money, as well as other utility methods.
public abstract class BankAccount {
    private String accountNumber;
    private String ownerName;
    private String ownerId;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, String ownerId, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    // Withdraws a given amount from the account. Throws an IllegalBalance exception if there are insufficient funds.
    public void withdraw(double amount) throws IllegalBalance {
        if (amount > balance) {
            throw new IllegalBalance("Insufficient funds");
        }
        this.balance -= amount;
    }
     public double getBalance() {
         return balance;
     }

    // Abstract method for monthly management. Must be implemented by concrete subclasses.
    public abstract void monthlyManagement();

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Owner: " + ownerName + ", Balance: " + balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount that = (BankAccount) obj;
        return accountNumber.equals(that.accountNumber) &&
                ownerName.equals(that.ownerName) &&
                ownerId.equals(that.ownerId);
    }
}

// Custom exception representing illegal balance operations, e.g., insufficient funds during a withdrawal.
class IllegalBalance extends Exception {
    public IllegalBalance(String message) {
        super(message);
    }
}
