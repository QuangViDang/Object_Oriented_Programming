package BTTH_Tuan4_1.Bai1;

public class Circle extends Point {
    private double radius;
    private Point center;

    public Circle() {
        super();
        this.center = new Point();
        this.radius = 1.0;
    }

    public Circle(int xCenter, int yCenter, double radius) {
        super(xCenter, yCenter);
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
    }

    public Circle(Point center, double radius) {
        super(center.getX(), center.getY());
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    public void setRadius(double radius) { this.radius = radius; }

    public Point getCenter() { return center; }

    public void setCenter(Point center) {
        this.center.setX(center.getX());
        this.center.setY(center.getY());
        setXY(center.getX(), center.getY());
    }

    public int getCenterX() { return center.getX(); }

    public void setCenterX(int x) { center.setX(x); }

    public int getCenterY() { return center.getY(); }

    public void setCenterY(int y) { center.setY(y); }

    public int[] getCenterXY() { return center.getXY(); }

    public void setCenterXY(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
        setXY(x, y);
    }

    public double getArea() { return Math.PI * radius * radius; }

    public double getCircumference() { return Math.PI * 2 * radius; }

    public double distance(Circle another) {
        return center.distance(another.getCenter());
    }

    public String toString() {
        return "Circle[center=" + center.toString() + ",radius=" + radius + "]";
    }
}