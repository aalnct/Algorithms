package neetcode150.tree;

public class BinaryTreeMaximumDepth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
           this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);

        System.out.println(calculateDepth(treeNode));
    }

    static int calculateDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
