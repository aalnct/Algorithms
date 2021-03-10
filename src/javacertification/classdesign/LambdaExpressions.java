package javacertification.classdesign;

public class LambdaExpressions {
    public static void main(String[] args) {
        Printable i = new Printable() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        };
        i.print("Welcome");

        Printable p = (String message) -> {System.out.println(message);};
        Printable p1 = (message) -> System.out.println(message);

        Operator operator = (int x, int y) -> {return x+y;};
        //Operator operator1 = (x, y) -> return x+y;;
        Operator operator2 = (x,y) -> x+y;
        //Operator operator3 = x,y -> x+y;


    }
}

interface Printable {
    void print (String message);
}

interface Operator {
    int operate (int i, int j);
}

