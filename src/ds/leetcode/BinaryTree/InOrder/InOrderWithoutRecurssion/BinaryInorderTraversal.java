package ds.leetcode.BinaryTree.InOrder.InOrderWithoutRecurssion;

import java.util.Stack;

/**
 * Created by AmitAgarwal on 6/11/20.
 */

class Node {
    public int data;
    public Node left;
    public Node right;


    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryInorderTraversal {

    public static Node root;

    public static void main(String[] args) {
        BinaryInorderTraversal bst = new BinaryInorderTraversal();
        bst.root = new Node(1);
        bst.root.left = new Node(2);
        bst.root.right = new Node(3);
        bst.root.left.left = new Node(4);
        bst.root.left.right = new Node(5);

        inOrderTraversal();
    }

    public static void inOrderTraversal(){
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current!=null || stack.size() > 0){
            /**
             * Reach the left most node
             */
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println("Printing :" + current.data);

            current = current.right;
        }
    }

}
