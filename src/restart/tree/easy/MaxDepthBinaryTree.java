package restart.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(4);
        root.right = new TreeNode1(7);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(9);

        System.out.println(maxDepth(root));

        System.out.println(maxDepth_BFS(root));
    }

    // using DFS approach (recurssion)
    private static int maxDepth (TreeNode1 root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth,rightDepth);

    }

    private static int maxDepth_BFS (TreeNode1 root) {
        if (root == null) return 0;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;


        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i < levelSize; i++) {
                TreeNode1 node  = queue.poll();
                assert node != null;
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
