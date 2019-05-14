package ds.doublylinkedlist;

/**
 * Created by AmitAgarwal on 11/26/18.
 */
public class DoublyLinkedListApp {
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(100);
        list.insertFirst(50);
        list.displayList();

        Node temp = list.deleteFirst();
        System.out.println( "Deleted First node : " + temp.getData());


        temp = list.deleteLast();
        System.out.println("Deleted Last node : " + temp.getData());
    }
}
