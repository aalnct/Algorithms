package javacertification.classdesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest  {

    public static void main(String[] args) {
        List<Player8> list = new ArrayList<>();

        list.add(new Player8("Sachin", 44, 1000));
        list.add(new Player8("Virat", 30, 100));
        list.add(new Player8("Yuvraj", 90,30));

        Comparator <Player8> comparator = new Comparator<Player8>() {
            @Override
            public int compare(Player8 player1, Player8 player2) {
                if (player1.salary > player2.salary) {
                    return 1;
                }else {
                    return -1;
                }

            }
        };

        Collections.sort(list,comparator);

        for (Player8 p : list) {
            System.out.println(p);
        }
    }
}


class Player8 implements Comparable<Player8>{
    String name;
    long salary;
    int age;

    Player8 (String name, int age, long salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Player8 player8) {
        if (this.age > player8.age) {
            return 1;
        }else if (this.age < player8.age) {
            return -1;
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "Player8{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}