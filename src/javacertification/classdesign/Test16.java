package javacertification.classdesign;

public class Test16 {
    private static class ClassEFG {
        private void log () {
            System.out.println("log");
        }
    }
    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            void draw() {
                System.out.println("Drawing a " + getShapeType());
            }
        };
        shape.draw();

        ClassEFG c = new ClassEFG();

        ClassABC.Animal abc  = new ClassABC.Dog();
        abc.eat();

        Out1.Inner in = new Out1.Inner();
        in.greet ("Hello1");
        Out1.Inner.greet("hello2");

    }
}

class Out1 {
    interface  in {
        void m1 ();
    }
    static class Inner {
        static void greet (String s) {
            System.out.println(s);
        }
    }
}

class ClassABC {
    private static int i = 20;
    private int j = 10;

    abstract static class Animal {
        abstract void eat ();
    }

    static class Inner {
        void add (){
            // System.out.println(i+j); non static field cannot be referenced from static context
        }
    }

    static class Dog extends Animal {
        //@Override
        void eat() {
            System.out.println("DOg eats");
        }
    }
}

enum ShapeType {
    CIRCLE, SQUARE, RECTANGE;
}

abstract class Shape {
    private ShapeType shapeType = ShapeType.SQUARE;

    Shape () {}
    Shape (ShapeType type) {
        this.shapeType = type;
    }

    public ShapeType getShapeType (){
        return shapeType;
    }

    abstract void draw ();
}

interface int1 {
    void m1 ();

    interface int2 {
        void m2 ();
    }

    abstract class A1 {
        public abstract void m3 ();
    }
    class A2 {
        public void m4 (){
            System.out.println(4);
        }
    }
}
