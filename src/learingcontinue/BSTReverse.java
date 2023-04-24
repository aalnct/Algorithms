package learingcontinue;

public class BSTReverse {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = reverseTree(root.left);
        TreeNode right = reverseTree(root.right);

        // swap
        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original Tree");
        printTree(root);

        System.out.println("Reversed Tree");
        printTree(reverseTree(root));
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.value + " ");
            printTree(root.right);
        }
    }

}
