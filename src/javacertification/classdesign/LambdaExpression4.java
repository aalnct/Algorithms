package javacertification.classdesign;

public class LambdaExpression4 {
    public static void main(String[] args) {
        ThreeDPrinter1 three = () -> System.out.println("3DPrinter");
        three.print();
    }
}

interface Printer4 {
    default void print () {
        System.out.println("Printer");
    }
}

@FunctionalInterface
interface ThreeDPrinter1 extends Printer4 {
    @Override
    void print ();
}
