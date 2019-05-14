package ds.circularlinkedlist;

/**
 * Created by AmitAgarwal on 11/25/18.
 */
public class CircularLinkedListApp {
    public static void main(String[] args){

        CirclularLinkedList list = new CirclularLinkedList();

        list.insertFirst(100);
        list.insertFirst(50);
        list.insertFirst(10);
        list.insertFirst(99);
        list.insertFirst(80);
        list.insertLast(111);

        list.displayList();

    }
}
