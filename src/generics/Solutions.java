package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitAgarwal on 6/2/20.
 */

class Container<T> {

    T value; // generics
    List<T> list = new ArrayList<T>(); // generic list

    public void getData(){
        System.out.println(value);
    }

    public void printList(){
        list.forEach(l -> System.out.println(l));
    }


}

public class Solutions {

    public static void main(String[] args) {
        Container<Integer> container = new Container();
        container.value = 10;
        container.list.add(10);
        container.list.add(20);
        container.list.add(30);
        container.list.add(40);
        container.getData();
        container.printList();


        Container<String> container1 = new Container();
        container1.value = "Amit";
        container1.list.add("Name 1");
        container1.list.add("Name 2");
        container1.list.add("Name 3");
        container1.list.add("Name 4");

        container1.getData();
        container1.printList();
    }
}
