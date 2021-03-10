package fb;

public class PreOrderRecurssive {

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
        preorderRecurssion(node);
    }

    static void preorderRecurssion (TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorderRecurssion(root.left);
        preorderRecurssion(root.right);
    }
}
