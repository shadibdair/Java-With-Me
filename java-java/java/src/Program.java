public class Program {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4, 5, 2);
        int result = r1.getArea();
        System.out.println("Area: " + result);

        Rectangle r2 = new Rectangle();
        r2.show();
        System.out.println("Perimeter: " + r2.getPerimeter());
    }
}
