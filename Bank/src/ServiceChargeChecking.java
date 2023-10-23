// This class represents a checking account that incurs a monthly service charge.
// The monthly service charge can either be a default value or set explicitly.
public class ServiceChargeChecking extends CheckingAccount {
    private static final double DEFAULT_SERVICE_CHARGE = 5.0;  // Default service charge
    private double serviceCharge;

    public ServiceChargeChecking(String accountNumber, String ownerName, String ownerId, double balance) {
        this(accountNumber, ownerName, ownerId, balance, DEFAULT_SERVICE_CHARGE);
    }

    public ServiceChargeChecking(String accountNumber, String ownerName, String ownerId, double balance, double serviceCharge) {
        super(accountNumber, ownerName, ownerId, balance);
        this.serviceCharge = serviceCharge;
    }

    // Getter and setter for serviceCharge
    // ... (for brevity)

    @Override
    public void monthlyManagement() {
        try {
            super.withdraw(serviceCharge);
        } catch (IllegalBalance ex) {
            System.out.println("Failed to deduct service charge due to insufficient funds.");
        }
    }
}
