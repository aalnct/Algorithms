package ds.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by AmitAgarwal on 3/19/19.
 */
public class DataStructure {

    Deque<String> deque = new ArrayDeque();
    Deque<Integer> linkedListDeque = new LinkedList();


    public static void main(String [] args){
        DataStructure ds = new DataStructure();
        ds.dequeueArrayDeque();
        ds.dequeueLinkedList();
    }

    public void dequeueArrayDeque(){
        deque.add("Name1");
        deque.addLast("Name2");
        deque.add("Name3");

        deque.forEach(System.out :: println);

        Object lastElement = deque.peekLast();
        System.out.println(" :: " + lastElement);

    }

    public void dequeueLinkedList(){
        linkedListDeque.add(1);
        linkedListDeque.addLast(2);
        linkedListDeque.add(3);

        linkedListDeque.forEach(System.out::println);

        Object lastElement = linkedListDeque.peekLast();
        System.out.println(" :: " + lastElement);
    }



}
