public class Car {
    private String licensePlate;
    private int currentSpeed;
    private int maxSpeed;

    public Car(String licensePlate, int maxSpeed) {
        this.licensePlate = licensePlate;
        this.currentSpeed = 0;
        this.maxSpeed = maxSpeed;
    }

    public void speedUp(int amount) {
        if (amount > 0) {
            this.currentSpeed = Math.min(this.currentSpeed + amount, this.maxSpeed);
        }
    }

    public void slowDown(int amount) {
        if (amount > 0) {
            this.currentSpeed = Math.max(this.currentSpeed - amount, 0);
        }
    }

    public void show() {
        System.out.println("License Plate: " + licensePlate + ", Current Speed: " + currentSpeed + ", Max Speed: " + maxSpeed);
    }

    public int getSpeed() {
        return this.currentSpeed;
    }
}
