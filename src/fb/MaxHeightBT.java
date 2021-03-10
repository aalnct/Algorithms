package fb;

public class MaxHeightBT {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        int height = findMaxHeightBT(tree);
        System.out.println(height);
    }

    static int findMaxHeightBT (TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight,rightHeight);
    }

    static int height(TreeNode node) {
        if (node == null){
            return 0;
        }

        return  Math.max(height(node.left), height(node.right)) + 1;


    }
}
