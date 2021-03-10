package javacertification.functionalinterfaceandstreamapi;

public class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    boolean filter () {
        return this.x == this.y;
    }
}
