package javacertification.classdesign;

public class Test12 {

    class TestA {
        void method () {
            System.out.println("INNER");
        }
    }

    public static void main(String[] args) {
        new Outer().new Inner().printName();
        TestA testA = new Test12().new TestA();
        //TestA testB = this.new TestA(); // this cannot be referenced from static context
        testA.method();
    }
}

class Outer {
    private String name = "James";
    class Inner {
        public void printName () {
            System.out.println(name);
        }
    }
}


