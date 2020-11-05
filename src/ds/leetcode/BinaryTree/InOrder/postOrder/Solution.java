package ds.leetcode.BinaryTree.InOrder.postOrder;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class Solution {

    public static void main(String[] args) {
        PostOrder postOrder = new PostOrder();
        postOrder.root = new Node(1);

        postOrder.root.left = new Node(2);
        postOrder.root.right = new Node(3);
        postOrder.root.left.left = new Node(4);
        postOrder.root.left.right = new Node(5);

        postOrder.printPostOrder();
    }

}
