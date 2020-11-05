package LinkedListDataStructure;

/**
 * Created by AmitAgarwal on 5/22/19.
 */
public class SinglyLinkedList {

    // creating a singly linked list class

    public SinglyLinkedList(){}

    private Node first; // the very first node in the data structure
    private Node last; // points to the last index of list (circular linkedlist)

    /**
     * check if list is empty
     */

    public boolean isEmpty(){
        return (first == null);
    }


    public int listSize(Node node){
        int size = 0;

        while(node != null){
            node = node.next;
            size++;
        }

        return size;
    }

    /**
     *
     * @param data
     */
    public Node insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;

        return newNode;
    }

    /**
     *
     * @return
     */
    public Node deleteFirst(){
        Node temp = first;
        first =  first.next;
        return temp;
    }

    public void insertLast(int data){
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        // once current.next gets null - we will assign the data to next (to insert at the last index)
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

    /**
     *
     */
    public void displayList(){
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.print("");

    }



}
