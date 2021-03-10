package javacertification.classdesign;

public class LambdaExpression3 {
    int i = 100;

    Int3 obj1 = new Int3() {
        int i = 200;
        @Override
        public void print() {
            System.out.println(this.i);
        }
    };

    Int3 obj2 = () -> {
      int i = 300;
        System.out.println(this.i);
    };

    public static void main(String[] args) {

    }
}

@FunctionalInterface
interface Int3 {
    void print ();
}
