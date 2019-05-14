package ds.circularlinkedlist;

/**
 * Created by AmitAgarwal on 11/25/18.
 */
public class Node {

    private int data;

    private Node next = null;//this will be used to link all the nodes

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    //iterate the node and display it
    public void displayNode(){
        System.out.println("{" + data + "}");
    }
}

