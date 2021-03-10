package javacertification.classdesign;

public class Test14 {
    public static void main(String[] args) {
        new classFoo().new classBar();
        ClassOuter.ClassInner ci = new ClassOuter.ClassInner();

        new out().print(100);

        new A().someMethod("World");

        OuterA1.sayHello();
    }
}

class classFoo {
    static {
        System.out.println(1);
    }
    // inner class must be static to have static initializer block
    class classBar {
        /*static {
            System.out.println(2); // cannot call static block in
                                   // non-static inner class (nested class)
        }*/
    }
}

class ClassOuter {
    ClassOuter () {
        System.out.println(2);
    }

    static {
        System.out.println(1);
    }

   static class ClassInner {
        ClassInner () {
            System.out.println(4);
        }
        static {
            System.out.println(3);
        }
    }
}

class out {
    public void print (int x) {
        // inner class can be declared inside a method
        class in {
            public void getX () {
                // Variable 'x' is accessed from within inner class, needs to be final or effectively final
                // since we performing operations on class
                // System.out.println(++x);
            }
        }
        in i = new in();
        i.getX();
    }
}

class A {
    public void someMethod (final String name) {
        class B {
            void print () {
                System.out.println("Hello " + name);
            }
        }
        new B().print();
    }
}

class OuterA1 {
    public static void sayHello () { }
    static {
        class InnerA1 {
            /*InnerA1 () {
                System.out.println("Hello");
            }*/
            {
                System.out.println("Hello");
            }
        }
        new InnerA1();
    }
}
