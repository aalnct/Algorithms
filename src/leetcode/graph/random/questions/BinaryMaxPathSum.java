package leetcode.graph.random.questions;


class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class BinaryMaxPathSum {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTree node = new BinaryTree(1);
        node.left = new BinaryTree(2);
        node.right = new BinaryTree(3);
        node.left.left = new BinaryTree(4);
        node.left.right = new BinaryTree(5);

        node.right.left = new BinaryTree(6);
        node.right.right = new BinaryTree(7);

        System.out.println(maxPathSum(node));
    }

    private static int maxPathSum(BinaryTree node) {

        if(node == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSum(node.left),0);
        int rightSum = Math.max(maxPathSum(node.right),0);

        // also needs to consider the current node
        int currentNodeSum = node.data + leftSum + rightSum;

        maxSum = Math.max(maxSum, currentNodeSum);

        return node.data + Math.max(leftSum,rightSum);
    }
}
