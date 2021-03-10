package javacertification.classdesign;

public class OuterM {
    private int n = 100;
    class Inner {
         private int n2 = 100;
    }

    static class Inner2 {
        static void greetings (String s) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        OuterM outer = new OuterM();
        OuterM.Inner in = outer.new Inner();
        System.out.println(outer.n + in.n2);

        OuterM.Inner2 inner2 = new OuterM.Inner2();
        inner2.greetings("Hello");

        Inner2.greetings("Hello");

    }
}
