package javacertification.genericsandcollections;

import java.util.*;

public class Generics6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("T", "S", "R", "I", "F");
        ListIterator<String> iter = list.listIterator(2);
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) {
            //iterator.remove();
            iterator.next();
        }
        System.out.println(colors.size());

        Set<Student> set = new HashSet<>(); // no duplicates
        set.add(new Student("James", 22));
        set.add(new Student("James", 20));
        set.add(new Student("James", 22));

        System.out.println(set.size());

        Set<Student> treeSet = new TreeSet<>(Student::compareByName);
        treeSet.add(new Student("James", 22));
        treeSet.add(new Student("James", 20));
        treeSet.add(new Student("James", 22));

        System.out.println("Tree Set" + treeSet.size());

    }
}
