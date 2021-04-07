package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        // List<Double> result = averageLevelBinaryTree(node);
        List<Double> result  = averageOfLevels(node);
        result.forEach(System.out::println);
    }

    static List<Double> averageLevelBinaryTree (TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return new ArrayList<>();

        double total; // get the average sum value

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();
            total = 0;
            for (int i=0;i < size;i++) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                total += node.data;

                list.add(total * 1.0/size);
            }
        }
        return list;
    }

    static List<Double> averageOfLevels (TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            long sum = 0;
            long count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                sum += node.data;
                count++;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }

            queue = temp;
            list.add(sum * 1.0/count);
        }
        return list;
    }
}
