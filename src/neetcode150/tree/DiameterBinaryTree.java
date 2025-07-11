package neetcode150.tree;

public class DiameterBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        System.out.println(diameterBinaryTree(root));
    }

    static int maxDiameter = 0;

    static int diameterBinaryTree (TreeNode root) {
        maxDiameter = 0; // reset for each call
        calculateDiameter(root);
        return maxDiameter;
    }

    static int calculateDiameter (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calculateDiameter(root.left);
        int rightHeight = calculateDiameter(root.right);

        int currentDiameter = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter,currentDiameter);
        return Math.max(leftHeight , rightHeight) + 1;
    }
}