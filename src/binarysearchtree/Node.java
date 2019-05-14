package binarysearchtree;

/**
 * Created by AmitAgarwal on 3/28/19.
 */
public class Node {

    protected int key;
    protected String value;
    protected Node rightChild, leftChild;

    public Node(int key, String value){
        super();
        this.key = key;
        this.value = value;
    }

}
