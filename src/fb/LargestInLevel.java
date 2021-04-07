package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestInLevel {

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
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(9);
        List<Integer> result =  largestInLevel(node);
        result.forEach(System.out::println);
    }

    static List<Integer> largestInLevel (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                max = Math.max(max,node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
