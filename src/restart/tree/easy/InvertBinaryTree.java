package restart.tree.easy;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode1 {
    int value;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1(int value) {
        this.value = value;
    }
}
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(4);

        root.left = new TreeNode1(2);
        root.right = new TreeNode1(7);
        root.left.left = new TreeNode1(1);
        root.left.right = new TreeNode1(3);

        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(9);

        TreeNode1 ans = invert(root);
        printTree(ans);
    }

    private static TreeNode1 invert (TreeNode1 root) {
        if (root == null) {
            return null;
        }

        TreeNode1 left = invert(root.left);
        TreeNode1 right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    private static void printTree (TreeNode1 tree) {
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            TreeNode1 node = queue.poll();
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
