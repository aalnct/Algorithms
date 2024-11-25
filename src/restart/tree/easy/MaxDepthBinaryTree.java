package restart.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(maxDepth(root));

        System.out.println(maxDepth_BFS(root));
    }

    // using DFS approach (recurssion)
    private static int maxDepth (TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth,rightDepth);

    }

    private static int maxDepth_BFS (TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;


        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i < levelSize; i++) {
                TreeNode node  = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
