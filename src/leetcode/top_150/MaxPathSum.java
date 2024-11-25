package leetcode.top_150;

public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Tree node = new Tree(1);
        node.left = new Tree(2);
        node.right = new Tree(3);

        System.out.println(findMaxSum(node));
    }

    private static int findMaxSum(Tree root) {
        maxPathSum(root);
        return maxSum;
    }
    private static int maxPathSum(Tree node) {

        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(maxPathSum(node.left),0);
        int rightMax = Math.max(maxPathSum(node.right), 0);

        int currentMax = node.value + leftMax + rightMax;
        maxSum = Math.max(maxSum,currentMax);

        return node.value + Math.max(leftMax,rightMax);
    }
}
