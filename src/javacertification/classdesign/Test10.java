package javacertification.classdesign;

public class Test10 {
    enum Direction {
        NORTH("N"), SOUTH ("S");

        String notations;

        Direction(String notations) {
            this.notations = notations;
        }
    }

    public static void main(String[] args) {
        System.out.println(Test10.Direction.NORTH.notations);
        Flags flags1 = Flags.TRUE; // will call constructor twice
        Flags flags2 = Flags.TRUE;
        Flags flags3 = Flags.TRUE;

        System.out.println(Status.FAIL);
        System.out.println(Status.PASS);

        TrafficLight tl = TrafficLight.valueOf(args[0]);

        switch (tl) {
            case RED:
                System.out.println("STOP");
                break;
            case GREEN:
                System.out.println("GO");
                break;
            case YELLOW:
                System.out.println("SLOW");
                break;
        }
    }
}

enum Flags implements TestInterface{
    TRUE;

    Flags() {
        System.out.println("HELLO");
    }
}

enum Status {
    PASS, FAIL;
}

enum TrafficLight {
    RED, YELLOW,GREEN;
}