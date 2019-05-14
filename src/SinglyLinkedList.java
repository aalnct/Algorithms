/**
 * Created by AmitAgarwal on 11/25/18.
 */
public class SinglyLinkedList {
    private Node first;
    private Node last;//to insert the data at the last position

    public SinglyLinkedList(){}

    public boolean isEmpty(){
        return (first==null);
    }

    //used to insert at the beginning of list
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(first);
        first = newNode;
    }

    public Node deleteFirst(){
        Node temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList(){
        System.out.println("List (first-->last) ");
        Node current = first;
        while(current!=null){
            current.displayNode();
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * It is traversing the entire list to insert data at the end....
     * needs to have a better implementation....
     * @param data
     */
    public void insertLast(int data){
        Node current = first;
        //loop will check if linked list is null
        while(current.getNext()!=null){
            current = current.getNext(); //loop until next is null
        }
        //once it gets null, it will create a new node and insert the data at the last
        Node newNode = new Node();
        newNode.setData(data);
        current.setNext(newNode);

    }
}
