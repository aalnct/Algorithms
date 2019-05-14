package ds.doublylinkedlist;

/**
 * Created by AmitAgarwal on 11/26/18.
 */
public class DoublyLinkedList {

    private Node first;
    private Node last;

    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }

    //check if list is empty
    public boolean isEmpty(){
        return (first == null);
    }

    //Insert at the beginning of node
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.setData(data);

        if(isEmpty()){
            last = newNode; //if node is empty, then initialize with the new node
        }
        else{
            first.setPrevious(newNode);
        }

        newNode.setNext(first); //new node next will become old first
        this.first = newNode;
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.setData(data);

        if(isEmpty()){
            first = newNode;
        }
        else{
            last.setNext(newNode); //old last new node
            newNode.setPrevious(last);
        }

        last = newNode; //last field should point to new node
    }

    public Node deleteFirst(){ //we are assuming that list is non-empty
        Node temp = first; //assigning first node that needs to be deleted
        if(first.getNext() == null){
            last = null;
        }
        else{
            first.getNext().setPrevious(null);
        }
        first = first.next;
        return temp;
    }

    //assuming that list is non-empty
    public Node deleteLast(){
        Node temp = last; //passing a reference here
        if(first.getNext() == null){
            first = null;
        }
        else{
            last.getPrevious().setNext(null);//last node's previous node's next node will be null
        }
        last = last.previous;//previous node to be new last node
        return temp;
    }

    public boolean insertAfter(int key, int data){ //key - after which data needs to be inserted
        Node current = first; //we start from beginning
        while(current.data != key){
            current = current.next;
            while(current == null){
                return false;
            }
        }

        

        return true;
    }



    public void displayList(){
        System.out.println("Display list --> (First to last)");
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.getNext();
        }
        System.out.println("");
    }
}