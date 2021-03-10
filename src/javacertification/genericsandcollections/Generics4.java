package javacertification.genericsandcollections;

import java.util.ArrayList;
import java.util.List;

public class Generics4 {
    public static void main(String[] args) {

        List<? extends Number> list = new ArrayList<Integer>();

        // extends keyword

        /** you cannot do this, because it
         * will never know if list is pointing
         * to List<Double>
         *     this means writing is not guaranteed but reading is**/

        // list.add(10);

        /**
         * so we cannot add any number to <? extends T></?>
         * but we can read from it since it will provide T or
         * subclass of T
         */

        // super keyword

        /**
         * Reading is not guaranteed
         */

        List<? super Integer> list1 = new ArrayList<Integer>();
        List<? super Integer> list2 = new ArrayList<Number>();
        List<? super Integer> list3 = new ArrayList<Object>();

        String str = get("Hello");
        System.out.println(str);

        ClassA11<Dog> classA11 = new ClassA11();
        ClassA11<Animal> classA1 = new ClassA11();
        // print1(classA1);
        print2(classA11);
    }

    public static <T> void print1 (ClassA11 <? extends Animal> obj) {
        // expected <? extends Animal>
        // obj.set(new Dog());
        System.out.println(obj.get().getClass());
    }

    public static <T> void print2 (ClassA11 <? super Dog> obj) {
        obj.set(new Dog());
        System.out.println(obj.get().getClass());
    }

    private static <T> T get (T t) {
        return t;
    }
}


class Animal { }
class Dog extends Animal {}
class Cat extends Animal {}

class ClassA11<T> {
    T t;
    void set (T t) {
        this.t = t;
    }
    T get () {
        return t;
    }
}
