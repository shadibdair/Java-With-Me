public class Program3 {
    public static void main(String[] args) {
        Car car1 = new Car("12345", 120);
        Car car2 = new Car("123456", 100);

        car1.speedUp(5);
        car2.speedUp(1);

        car1.show();
        car2.show();

        System.out.println("Current speed of car2: " + car2.getSpeed());

        int rnd = (int)(Math.random() * 150 + 50);
        car2.speedUp(rnd);

        if (car2.getSpeed() > 30) {
            car2.speedUp(30 - car2.getSpeed());
        }

        car2.show();
    }
}
