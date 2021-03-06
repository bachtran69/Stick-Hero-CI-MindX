package game;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(Vector2D other) {
        this.add(other.x, other.y);
    }

    public void substract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void scale(double rate) {
        this.x *= rate;
        this.y *= rate;
    }

    public Vector2D clone() {
        return new Vector2D(x, y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public void setLength(double length) {
        double oldLength = this.getLength();
        if (oldLength != 0) {
            x = x / (oldLength / length);
            y = y / (oldLength / length);
        }
    }

    public double getAngle() {
        return Math.atan(y / x);
    }


    public void setAngle(double angle) {
        double length = this.getLength();
        if (length != 0) {
            x = Math.cos(angle) * length;
            y = Math.sin(angle) * length;
        }

    }

//    public static void main(String[] args) {
//        Vector2D v1 = new Vector2D(3, 3);
//        System.out.println(v1.getLength());
//        System.out.println(v1.getAngle());
//
//    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
