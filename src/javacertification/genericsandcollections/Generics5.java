package javacertification.genericsandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Generics5<T> {

    private T t;

    public T get (){
        return t;
    }

    public void set (T t) {
        this.t = t;
    }

    // this t cannot be referenced from static context
    // why generic parameter cannot be declare static
    // as static variable is shared among object, so compiler cannot determine which type to use
    // static T o;

    T[] obj;
    public Generics5 (){
        // cannot be instantiated directly, since all of the generics information
        // is erased during compile time.
        // obj = new T[100];
    }

    public static void main(String[] args) {
        List<String> list11 = new ArrayList<>(Arrays.asList("A","E", "I", "O"));
        list11.add("U");
        list11.forEach(System.out::print);


        List list12 = new ArrayList<String>();
        list12.add(1000);
        list12.add("2");

        list12.forEach(System.out::print);


        List<String> list13 = Arrays.asList("T", "S", "R", "I", "F");
        ListIterator<String> iter = list13.listIterator(5);
        while (iter.hasPrevious()) {
            System.out.print(iter.previous());
        }

        Generics5 ob = new Generics5();
        ob.set("OCP");
        ob.set(85);
        // this will override the last two values
        ob.set('%');

        System.out.println(ob.get());
        List<String> list3 = new ArrayList<>();
        list3.add("A");
        list3.add("B22");

        List<? extends Object> list4 = list3;
        list4.remove("A");
        // list4.add("C");

        list4.forEach(System.out::print);

        print(new Double(5.5));
        print(new Integer(1));
        // Number is an abstract class...

        List<? super String> list = new ArrayList<>(Arrays.asList("A", "E", "I", "O"));
        list.add("U");
        list.forEach(System.out::print);

        System.out.println("");

        List<? super String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.forEach(System.out::print);

        // List<Animal2> list2 = new ArrayList<Dog>();

        // System.out.println((s1,s2) -> {return s1 + s2;};);

        Operator<String> opr1 = (s1, s2) -> s1 + s2;
        Operator<Integer> opr2 = (i1, i2) -> i1 + i2;
        System.out.println(opr1.operations("Hello", "World"));
        System.out.println(opr2.operations(10,40));
    }

    private static <T extends Number>  void print (T t) {
        System.out.println(t.intValue());
    }

    private static final <X extends Integer, Y extends Integer> void add (X x, Y y){
        // operator + cannot be applied to x and y
        //System.out.println(x+y);
    }
}

abstract class Animal2 {}
class Dog2 extends Animal2 {}

interface Operation {
    long operate (long x, long y);
    public abstract T operation (T t1, T t2);
}

interface Operator<T> {
    public abstract T operations (T t1, T t2);
}
