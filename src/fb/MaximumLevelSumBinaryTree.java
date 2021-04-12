package fb;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(7);
        node.right = new TreeNode(0);
        node.left.left = new TreeNode(7);
        node.left.right = new TreeNode(-8);

        int max = maximumLevelSum(node);
        System.out.println(max);
    }

    static int maximumLevelSum (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = root.val;
        int level = 1;
        int answer = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum +=node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
                answer = level;
            }
            level++;
        }
        return answer;
    }
}
