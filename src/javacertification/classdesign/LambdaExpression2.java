package javacertification.classdesign;

public class LambdaExpression2 {
    public static void main(String[] args) {
        Int4 obj = () -> System.out.println("Lambda Expression");
        obj.print();
    }
}

@FunctionalInterface
interface Int4 {
    void print ();
    boolean equals (Object obj);
}

// must have one non-overriding abstract method
// @FunctionalInterface
interface Int5 {
    boolean equals (Object obj);
}