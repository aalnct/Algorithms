package neetcode150.tree;

public class BalancedBinaryTree {

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

        System.out.println(isBalancedTree(root));
    }

    static boolean isBalancedTree(TreeNode root) {
        return checkBalancedTree(root) != -1;
    }

    static int checkBalancedTree (TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkBalancedTree(node.left);
        if (leftHeight == -1) return -1;


        int rightHeight = checkBalancedTree(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }
}
