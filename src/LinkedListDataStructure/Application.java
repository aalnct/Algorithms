package LinkedListDataStructure;

/**
 * Created by AmitAgarwal on 5/22/19.
 */
public class Application {

    public static void main(String [] args){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        Node node = null;

        node = singlyLinkedList.insertFirst(40);
        node = singlyLinkedList.insertFirst(140);
        node = singlyLinkedList.insertFirst(30);
        node = singlyLinkedList.insertFirst(10);

        int size = singlyLinkedList.listSize(node);
        System.out.println( "size is: " + size + " ");

        node = singlyLinkedList.deleteFirst();
        size = singlyLinkedList.listSize(node);

        System.out.println( "size is: " + size + " ");

        singlyLinkedList.insertLast(1);

        singlyLinkedList.displayList();
    }
}
