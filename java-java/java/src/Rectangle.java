public class Rectangle {
    private int xu, yu;
    private int xl, yl;

    public Rectangle(int xu, int yu, int xl, int yl) {
        this.xu = xu;
        this.yu = yu;
        this.xl = xl;
        this.yl = yl;
    }

    public int getArea() {
        int width = xl - xu;
        int height = yu - yl;
        return width * height;
    }

    public Rectangle() {
        this.xu = 0;
        this.yu = 1;
        this.xl = 1;
        this.yl = 0;
    }

    public int getPerimeter() {
        int width = xl - xu;
        int height = yu - yl;
        return 2 * (width + height);
    }

    public void show() {
        System.out.println("xu=" + xu + ", yu=" + yu + ", xl=" + xl + ", yl=" + yl);
    }

}


