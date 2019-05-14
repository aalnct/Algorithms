package ds.doublylinkedlist;

/**
 * Created by AmitAgarwal on 11/26/18.
 */
public class Node {

    protected int data;
    protected Node previous;
    protected Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void displayNode(){
        System.out.println("{" + data + "}");
    }
}
