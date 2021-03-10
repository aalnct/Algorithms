package fb;

public class SearcInBST {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.data = data;
        }

        TreeNode (TreeNode root, int data) {
            this.data = data;
            this.left = this.right = root;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(10);
        node.right = new TreeNode(29);
        node.left.left = new TreeNode(9);
        node.left.right = new TreeNode(11);
        node.right.left = new TreeNode(25);
        node.right.right = new TreeNode(30);

        TreeNode n = findInBST(node,9);
        System.out.println(n.data);
    }

    static TreeNode findInBST (TreeNode node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data  == data) {
            return node;
        }

        TreeNode leftNode = findInBST(node.left,data);
        if(leftNode!=null  && leftNode.data == data) {
            return leftNode;
        }

        TreeNode rightNode = findInBST(node.right,data);
        if (rightNode != null && rightNode.data == data) {
            return rightNode;
        }

        return null;
    }
}
