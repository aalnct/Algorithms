package javacertification.classdesign;

public class Test8 {
    public static void main(String[] args) {
        Printer p1 = Printer.getInstance();
        Printer p2 = Printer.getInstance();
        Printer p3 = Printer.getInstance();

        System.out.println(Printer.getCount());
    }
}

class Printer {
    private static int count = 0;
    private Printer () {
        count++;
    }

    static Printer getInstance() {
        return PrinterCreator.printer;
    }

    static class PrinterCreator {
        static Printer printer = new Printer();
    }

    static int getCount () {
        return count;
    }
}
