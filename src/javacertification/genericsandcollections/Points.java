package javacertification.genericsandcollections;

public class Points {
    public int x;
    public int y;

    public Points (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Points{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
