package LinkedListDataStructure.CicularLinkedList;

/**
 * Created by AmitAgarwal on 5/22/19.
 */
public class CicularLinkedList {

    private Node first;
    private Node last;

    public CicularLinkedList(){
        this.first = null;
        this.last = null;
    }

    private boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first; // current first node will become next node

        if(isEmpty()){
            last = newNode;
        }

        first = newNode;

    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            first = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
    }


    public void addNodeAtEnd(int data){
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty()){
            first = newNode;
        }else {
            last.next = newNode;
            last = newNode;
            // Circular Linked List
            last.next = first;
        }
    }

    public void displayList(){
        Node current = first;

        if(isEmpty()){
            System.out.print("List is empty!! nothing to print");
        }else {
            do {
                System.out.println("Printing :" + current.data);
                current = current.next;
            }
            while(current != null);
        }
    }

}
