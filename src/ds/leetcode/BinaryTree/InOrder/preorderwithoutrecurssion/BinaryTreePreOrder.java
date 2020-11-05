package ds.leetcode.BinaryTree.InOrder.preorderwithoutrecurssion;

import java.util.Stack;

/**
 * Created by AmitAgarwal on 6/14/20.
 */

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data){
        this.data =data;
        this.left = this.right = null;
    }
}

public class BinaryTreePreOrder {

    public Node root;

    public static void main(String[] args) {
        BinaryTreePreOrder bst = new BinaryTreePreOrder();
        bst.root = new Node(10);
        bst.root.left = new Node(8);
        bst.root.right = new Node(2);
        bst.root.left.left = new Node(3);
        bst.root.left.right = new Node(5);
        bst.root.right.left = new Node(2);

        bst.iterativeOrder();
    }

    public void iterativeOrder(){
        iterativeOrder(root);
    }

    public void iterativeOrder(Node root){
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node myNode = stack.peek();
            System.out.println(myNode.data); // first node --> root
            stack.pop(); //remove the root node once printed

            if(myNode.right!=null){
                stack.push(myNode.right);
            }
            if(myNode.left != null){
                stack.push(myNode.left); // push right first because stack is LIFO (last in first out)
            }
        }
    }
}
