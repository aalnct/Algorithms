/**
 * Created by AmitAgarwal on 11/25/18.
 */
public class SinglyLinkedListDemo {
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();

        //sort the data while doing insertion
        list.insertFirst(100);
        list.insertFirst(50);
        list.insertFirst(10);
        list.insertFirst(99);
        list.insertFirst(80);
        list.insertLast(111);

        list.displayList();
    }
}
