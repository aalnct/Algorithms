package fb;

import java.util.LinkedList;
import java.util.Queue;

public class AddRowToTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main (String[] args) {

    }

    static TreeNode adOneRow (TreeNode root, int value, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(value);
            n.left = root;
            return n;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (level == depth-1) {
                    TreeNode newLeft = new TreeNode(value);
                    TreeNode newRight = new TreeNode(value);
                    newLeft.left = node.left;
                    newRight.right = node.right;
                    node.left = newLeft;
                    node.right = newRight;
                }
            }
        }
        return root;
    }
}
