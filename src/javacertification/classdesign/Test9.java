package javacertification.classdesign;

public class Test9 {
    public static void main(String[] args) {
        Point p = new Point();
        System.out.println(p);
        Calculator.add(15,20);

        System.out.println(a);
    }

    static int a = 10000;

    static {
        --a;
    }
    {
        ++a;
    }
}

class Calculator {
    public static void add (int x, int y) {
        System.out.println("The sum is :" + x + y); // if we put a bracket it will give a sum (x+y)
    }
}

class Point {
    private int x;
    private int y;

    Point () {
        // Point(10,20); cannot do this
        this(10,20); // to call a constructor from another constructor of the same class
    }

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
}
