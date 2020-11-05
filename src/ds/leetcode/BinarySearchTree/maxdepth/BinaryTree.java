package ds.leetcode.BinarySearchTree.maxdepth;

/**
 * Created by AmitAgarwal on 6/3/20.
 */

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data  = data;
        this.left = this.right = null;
    }

}

public class BinaryTree {

    Node root;

    /**
     *  Recursively
     */

    public int maxDepth(Node node){
        if(node == null){
            return 0;
        }

        // find height of left subtree
        int lDepth = maxDepth(node.left);

        // find height of right subtree
        int rDepth = maxDepth(node.right);

        if(lDepth > rDepth){
            return lDepth+1;
        }else {
            return rDepth+1;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        System.out.println("Height of Binary Tree :" + bt.maxDepth(bt.root));
    }

}
