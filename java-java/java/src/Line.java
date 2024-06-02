public class Line {
    private double x1, y1, x2, y2;

    public Line() {
        this.x1 = 0.0;
        this.y1 = 1.0;
        this.x2 = 4.0;
        this.y2 = 3.0;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line(double x2, double y2) {
        this.x1 = 0.0;
        this.y1 = 0.0;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void show() {
        System.out.println("(" + x1 + ", " + y1 + ") - (" + x2 + ", " + y2 + ")");
    }

    public double getSlope() {
        return (y2 - y1) / (x2 - x1);
    }

    public boolean isOnLine(double x, double y) {
        double slope = getSlope();
        double intercept = y1 - slope * x1;
        return Math.abs(y - (slope * x + intercept)) < 0.000001;
    }
}
