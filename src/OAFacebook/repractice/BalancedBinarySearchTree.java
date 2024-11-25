package OAFacebook.repractice;

public class BalancedBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(11);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(6);

        System.out.println(isBalancedBST(node));
    }

    static boolean isBalancedBST (TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) && isBalanced(root);
    }

    // to check if value is within range for each node ...
    static boolean isBST (TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isBST(node, min, node.data) &&
                isBST(node,node.data,max);
    }

    // to check if height is balanced ...
    static boolean isBalanced (TreeNode node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight,rightHeight) + 1;

    }

}
