package javacertification.classdesign;

public class Test18 {
    public static void main(String[] args) {
        Printer1 printer1 = new Printer1();
        printer1.print(); // calls the non-static default access
    }
}

interface Print2 {
     public static void print () {
        System.out.println("Print 2");
    }
}

interface Print1 {
    default void print (){
        System.out.println("Print 1");
    }
}

class Print3 {
    public void print () {
        System.out.println("Print 3");
    }
}

class Printer1 extends Print3 implements  Print2, Print1 {

}
