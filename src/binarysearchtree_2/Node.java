package binarysearchtree_2;

public class Node {

    // binary tree will have nodes
    Node left,right;

    // actual data that to be inserted....
    String  data;
    int key;

    public Node () {}

    public Node (int key, String data) {
        this.key = key;
        this.data = data;
    }
}
