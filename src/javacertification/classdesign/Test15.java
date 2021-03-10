package javacertification.classdesign;

public class Test15 {
    public static void main(String[] args) {
        Message message = new Message() {
            int x = 10; // anonymous inner class
            public void PrintMessage () {
                System.out.println("HELLO!");
            }
        };
        message.printMessage();

        Greeting greet = new Greeting() {
            @Override
            void greet() {
                System.out.println("Hello!!!!");
            }
        };
        greet.greet();

        flyable fly = new flyable() {
            @Override
            public void fly() {
                System.out.println("Flying high");
            }
        };
        fly.fly();

        System.out.println(new Object() {
            public String toString () {
                return "Anonymous";
            }
        });
        printPrice(null);
        printPrice(new Sellabe() {
            @Override
            public double sell() {
                return 0;
            }
        });
    }
    private static void printPrice (Sellabe sellabe) {
        System.out.println(sellabe.sell());
    }
}

interface Sellabe {
    public double sell ();
}

interface flyable {
    public void fly ();
}
abstract class Greeting {
    abstract void greet ();
}

class Message {
    public void printMessage () {
        System.out.println("Hello!!");
    }
}

class testA {
    public void print (String name) {
        class testB {
            testB () {
                System.out.println(name);
            }
        }
    }
    // testB t = new testB ();  // calling outside the scope of inner class, so it will not
    // be able to find it.
}

class testOuterA {
    private String message = "A";
    public void print () {
        final String msg = "B";
        class TestInnerA {
            // final String msg = "B";
            public void print () {
                //System.out.println(msg); // this will work
               // System.out.println(this.msg); since there is no field defined as msg within the class
                                                // scope, cannot use this reference
            }
        }
    }
}
