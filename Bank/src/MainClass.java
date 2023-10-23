// Shadi Badir
public class MainClass {
    public static void main(String[] args) {
        // Create different account types
        BankAccount serviceChargeAccount = new ServiceChargeChecking("12345", "Shadi Badir", "0123456789", 500, 10);
        BankAccount noServiceChargeAccount = new NoServiceChargeChecking("67890", "Lionel Messi", "9876543210", 700, 500);
        BankAccount interestCheckingAccount = new InterestChecking("11223", "Ronaldo", "1122334455", 800, 0.03);
        BankAccount savingsAccount = new SavingsAccount("33445", "Xavi", "5566778899", 900, 0.04);
        BankAccount highInterestSavingsAccount = new HighInterestSavings("55667", "Raul", "9988776655", 1000, 0.05, 600);

        // Perform operations on accounts
        System.out.println("Initial details of the accounts:");
        printDetails(serviceChargeAccount, noServiceChargeAccount, interestCheckingAccount, savingsAccount, highInterestSavingsAccount);

        // Deposit money into accounts
        serviceChargeAccount.deposit(200);
        noServiceChargeAccount.deposit(300);
        interestCheckingAccount.deposit(400);
        savingsAccount.deposit(500);
        highInterestSavingsAccount.deposit(600);

        System.out.println("\nDetails after deposit operations:");
        printDetails(serviceChargeAccount, noServiceChargeAccount, interestCheckingAccount, savingsAccount, highInterestSavingsAccount);

        // Withdraw money from accounts
        withdrawFromAccount(serviceChargeAccount, 100);
        withdrawFromAccount(noServiceChargeAccount, 100);
        withdrawFromAccount(interestCheckingAccount, 100);
        withdrawFromAccount(savingsAccount, 100);
        withdrawFromAccount(highInterestSavingsAccount, 100);

        System.out.println("\nDetails after withdrawal operations:");
        printDetails(serviceChargeAccount, noServiceChargeAccount, interestCheckingAccount, savingsAccount, highInterestSavingsAccount);

        // Monthly management
        serviceChargeAccount.monthlyManagement();
        noServiceChargeAccount.monthlyManagement();
        interestCheckingAccount.monthlyManagement();
        savingsAccount.monthlyManagement();
        highInterestSavingsAccount.monthlyManagement();

        System.out.println("\nDetails after monthly management:");
        printDetails(serviceChargeAccount, noServiceChargeAccount, interestCheckingAccount, savingsAccount, highInterestSavingsAccount);
    }

    private static void withdrawFromAccount(BankAccount account, double amount) {
        try {
            account.withdraw(amount);
        } catch (IllegalBalance e) {
            System.out.println(e.getMessage());
        }
    }


    private static void printDetails(BankAccount... accounts) {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
}
