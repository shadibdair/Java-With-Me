public class Program2 {
    public static void main(String[] args) {
        Line line1 = new Line();
        line1.show();
        System.out.println("Slope: " + line1.getSlope());

        Line line2 = new Line(1.0, 2.0, 3.0, 4.0);
        line2.show();
        System.out.println("Slope: " + line2.getSlope());

        System.out.println("Is point (2.0, 3.0) on line2? " + line2.isOnLine(2.0, 3.0));
        System.out.println("Is point (5.0, 6.0) on line2? " + line2.isOnLine(5.0, 6.0));
    }
}
