package ds.circularlinkedlist;

/**
 * Created by AmitAgarwal on 11/25/18.
 */
public class CirclularLinkedList {
    private Node first;
    private Node last;

    public CirclularLinkedList(){
        this.last = null;
        this.first = null;
    }

    public CirclularLinkedList(Node first, Node last){
        this.first = first;
        this.last = last;
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.setData(data);

        if(isEmpty()){
            last = new Node();
        }

        newNode.setNext(first);
        first = newNode;

    }
    //indicating node is null -- > no node in the list
    private boolean isEmpty() {
        return (first == null);
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.setData(data);

        if(isEmpty()){
            first = newNode;
        }else{
            last.setNext(newNode);
            last = newNode;
        }
    }

    public int deleteNode(int data){
        int temp = first.getData();
        if(first.getNext() == null){
            last = null;
        }
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
}
