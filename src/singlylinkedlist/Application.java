package singlylinkedlist;

/**
 * Created by AmitAgarwal on 4/2/19.
 */
public class Application {
    public static void main(String [] args){
        SinglyLinkedList ll = new SinglyLinkedList();

        ll.insertFirst(10);
        ll.insertFirst(50);
        ll.insertFirst(7);
        ll.insertFirst(1);


        ll.insertLast(10000);

        ll.displayFirst();
    }
}
