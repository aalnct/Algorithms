package neetcode150.tree;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {
        this.val = val;
    }
}
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original tree (level order):");
        printTree(root);

        // Invert the tree
        TreeNode inverted = invertBinaryTree(root);

        System.out.println("\nInverted tree (level order):");
        printTree(inverted);
    }

    static TreeNode invertBinaryTree (TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode leftChild  = invertBinaryTree(root.right);
        TreeNode rightChild = invertBinaryTree(root.left);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    static void printTree (TreeNode root) {
        if (root == null) {
           return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();

            for (int i=0; i < level; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val + " ");

                if (node.left != null ) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                System.out.println();
            }
        }
    }
}
