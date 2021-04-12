package fb;

public class MinimumDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        int minimum =  minimumDepth(node);
        System.out.println(minimum);
    }

    static int minimumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minimumDepth(root.right)+1;
        }

        if (root.right == null) {
            return minimumDepth(root.left) +1;
        }

        return Math.min(minimumDepth(root.left) , minimumDepth(root.right))+1;
    }
}
