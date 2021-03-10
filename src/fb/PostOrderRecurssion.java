package fb;

/**
 * DFS Implementation of PostOrder
 */
public class PostOrderRecurssion {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        postOrderRecurssion(node);
    }

    static void postOrderRecurssion(TreeNode root) {
        if (root == null) {
            return;
        }
            postOrderRecurssion(root.left);
            postOrderRecurssion(root.right);
            System.out.println(root.data);
    }
}
