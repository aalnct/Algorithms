package restart.tree.easy;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
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

        TreeNode ans = invert(root);
        printTree(ans);
    }

    private static TreeNode invert (TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    private static void printTree (TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(" " + node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
