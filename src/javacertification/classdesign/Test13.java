package javacertification.classdesign;

public class Test13 {
    public static void main(String[] args) {
        new classA().new classB(null).method();
        OuterA.innerA obj1 = new OuterA().new innerA();
        obj1.method();

        classA1.B1 object = new classA1().new B1();
        // B1 object = new classA1().new B1() // since B1 is an inner class it cannot be called
                                                // called directly

        Foo f = new Foo();
        // cannot call static class using instance variable
        // Foo.Bar b1 = f.new Bar();
        Foo.Bar b = new Foo.Bar();
        b.method1();

        classM m = new classM();
        classM.classN n = m.new classN();
        System.out.println(m.num + n.num);

        new classX().invokeInner();

        new classP().new ClassQ().print();
    }
}

class classA {
    private String str = "Hello";
    public class classB {
        public classB(String s) {
            if (s!=null) {
                str = s;
            }
        }
        public void method () {
            System.out.println(str);
        }
    }
}

class OuterA {
    class innerA {
        public void method () {
            System.out.println("Welcome");
        }
    }
}

class classA1 {
    public classA1 () {
        System.out.println(1);
    }
    class B1 {
        public B1 () {
            System.out.println(2);
        }
    }
}

class Foo {
    public static void method1 () {
        System.out.println("Foo : m1()");
    }
    static class Bar {
        // inner class cannot have static method
        // if class is not declared static
        public static void method1() {
            System.out.println("Bar : m1()");
        }
    }
}

class classM {

    public int num = 100;

    class classN {
        public int num = 200;
    }
}

class classX {
    class classY {
        private void method () {
            System.out.println("Inner");
        }
    }

    public void invokeInner () {
        classY classY = new classY();
        classY.method();
    }
}

class classP {
    private int var = 100;
    class ClassQ {
        String var = "Java";
        void print () {
            System.out.println(":::" + var);
        }
    }
}