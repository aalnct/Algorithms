package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitAgarwal on 6/2/20.
 */

class Client<T extends Number> {

    T value;

     protected void getData(){
        System.out.println(value);
    }

    public static void addIntegers(List<? extends Integer> list){
        list.forEach(t -> System.out.println(t));
    }
}

public class Runner {

    public static void main(String[] args) {
        Client<Integer> client = new Client();
        client.value = 5;
        client.getData();

        Client<Integer> client1 = new Client();
        client1.value = Integer.valueOf(9);
        client1.getData();


        List<Integer> list = new ArrayList<>();
        list.add(10);

        Client.addIntegers(list);
    }
}
