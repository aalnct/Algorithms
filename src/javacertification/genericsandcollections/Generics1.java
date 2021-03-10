package javacertification.genericsandcollections;

public class Generics1 {
    public static void main(String[] args) {
        Printer<T> obj = new Printer<>(new T());
        System.out.println(obj);
    }
}

class T {
    public String toString () {
        return "T";
    }
}

class Printer<T> {
    private T t;
    Printer (T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "t=" + t.toString() +
                '}';
    }
}
