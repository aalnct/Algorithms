package javacertification.genericsandcollections;

public class Genrics2 {
    public static void main(String[] args) {
        Printer1<Integer> obj = new Printer1<>(100);
        System.out.println(obj);
    }
}

class Printer1<String> { // here string become a generic (it is not referring to String class)
    private String t;
    Printer1 (String t) {
        this.t = t;
    }
}

class Printer2 <String> {
    private String t;
    Printer2 (String t) {
        this.t = t;
    }

    // here String generics is clashing with the object class toString method
    // will not work
    /*public String toString () {
    }*/
}

class GenricPrinter<T> {}

abstract class Abstract<X,Y,T> extends GenricPrinter<T> {}
