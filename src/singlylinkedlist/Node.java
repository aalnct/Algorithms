package singlylinkedlist;

/**
 * Created by AmitAgarwal on 4/1/19.
 */
public class Node {
    protected int data;
    protected Node next = null;

    protected void displayNode(){
        System.out.println("{" + data + "}");
    }
}
