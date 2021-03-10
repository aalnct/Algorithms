package javacertification.classdesign;

public class Test17 {
    String var = "Lambda";
    class Inner {
        int var = 1000;
        I1 obj1 = () -> System.out.println(this.var);
    }

    I1 i1 = new I1() {
        int i = 200;
        @Override
        public void print() {
            System.out.println(this.i);
        }
    };

    I1 i2 = new I1() {
        int i = 200;
        @Override
        public void print() {
            System.out.println(this.i);
        }
    };

    public static void main(String[] args) {
        Inner inner = new Test17().new Inner();
        inner.obj1.print();
        int i =100; // this cannot be referred using 'this' since it is
                    // defined in static context
        // target type for lambda expression must be an interface
        /*Greeting1 obj = (String s) -> {
            System.out.println();
        }*/;

        Test17 t = new Test17();
        t.i1.print();
        t.i2.print();
        int j = 400;
        I1 obj3 = () -> System.out.println(j);
        obj3.print();

        I1 obj4 = () -> {
          int k = 10;
          k++;
            System.out.println(k);
        };
        obj4.print();

        // System.out.println(++j); value used on lambda needs to be declare final

        method(s -> System.out.println(s.toUpperCase()), "greetings");

        int x = 10;
        int y = 20;
        // Operations oper = (x,y) -> x*y; // this will not work since x and y already defined
        Operations oper = (a,b) -> a*b;
        System.out.println(oper.operate(5,10));

    }
    private static void method (i10 i , String text) {
        i.m(text);
    }
}

interface Operations {
    int operate (int x, int y);
    // with default access modifier we can have body for interface method
    // or with public static
    public static void Print () {
        System.out.println("Printer");
    }
    default void Print1 () {
    }
}

@FunctionalInterface
interface ThreeDPrinter extends Operations {
    // Functional Interface can have only one method

}

interface i10 {
    void m (String str);
}

abstract class Greeting1 {
     abstract void greet (String s);
}
@FunctionalInterface
interface I1 {
     void print ();
    //int calc(int x);
}
