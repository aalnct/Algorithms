package javacertification.genericsandcollections;

// ClassA should be at the start
public class Generics3<T extends ClassA & IntM & IntN> {
    public static void main(String[] args) {
        Generics3<ClassD> obj = new Generics3<>();

        // String will not work here since it is extending cloneable interface
        Printer3 <Cloneable> print = new Printer3<>();
        System.out.println(print);
    }
}

class ClassA {}
interface IntM {}
interface IntN {}

class ClassB extends ClassA {}
class ClassC extends ClassA implements IntM, IntN {}
class ClassD extends ClassA implements IntM, IntN {}

class Printer3 <T extends Cloneable> {}
class Printer4 <T extends String> {}

class ClassA1<T extends String> {}
// class ClassB1<T super String> {} <T super String> will not work here ????

