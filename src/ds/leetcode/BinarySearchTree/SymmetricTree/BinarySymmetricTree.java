package ds.leetcode.BinarySearchTree.SymmetricTree;

/**
 * Created by AmitAgarwal on 6/7/20.
 */

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key){
        this.key = key;
        this.left = this.right = null;
    }
}

public class BinarySymmetricTree {

    private Node root;

    public static void main(String[] args) {
        BinarySymmetricTree bst = new BinarySymmetricTree();
        bst.root = new Node(1);
        bst.root.left = new Node(2);
        bst.root.right = new Node(2);

        bst.root.left.left = new Node(3);
        bst.root.left.right = new Node(4);

        bst.root.right.left = new Node(5);
        bst.root.right.right = new Node(3);

        boolean output = bst.isSymmetric(bst.root);
        if(output){
            System.out.println("True");
        }else {
            System.out.println("False");
        }


    }

    public boolean isSymmetric(Node root){
        return isMirror(root,root);
    }

    private boolean isMirror(Node node1, Node node2) {
        if(node1 == null && node2 == null){return true;}

        // root node key must be same
        // left subtree of left tree and right subtree or right tree must be mirror images
        // right subtree of left tree and left subtree of right tree must be mirror images

        if(node1 !=null && node2 != null && node1.key == node2.key){
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }

        return false;
    }

}
