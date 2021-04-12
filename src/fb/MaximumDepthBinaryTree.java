package fb;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        int n = maximumDepth(node);
        System.out.println(n);

        int n1 = maximumDepthBFS(node);
        System.out.println(n1);
    }

    static int maximumDepth (TreeNode root) {

        int count =1;

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return count;
        }

        if (root.left == null) {
            return maximumDepth(root.right)+1;
        }

        if (root.right == null) {
            return maximumDepth(root.left) + 1;
        }

        return Math.max(maximumDepth(root.left) , maximumDepth(root.right)) +1;

    }

    static int maximumDepthBFS (TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            ans++;

            for (int i=0; i<level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                // need to evict the elements from the queue
                queue.poll();
            }
        }
        return ans;
    }

}
