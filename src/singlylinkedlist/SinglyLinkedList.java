package singlylinkedlist;

/**
 * Created by AmitAgarwal on 4/1/19.
 */
public class SinglyLinkedList {
    private Node first;

    public SinglyLinkedList() {

    }

    //check if LinkedList is empty
    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(); //created a new node
        newNode.data = data; // set newNode data to initial data
        newNode.next = first;
        first = newNode;
    }

    public Node deleteFirst(){
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayFirst(){
        System.out.println("first --> last");
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }


    protected void insertLast(int data){
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }
}
