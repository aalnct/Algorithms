package OAFacebook.repractice;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode (int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);

        System.out.println(isBalancedTree(node));
    }

    static boolean isBalancedTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
}
