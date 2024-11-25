package leetcode.top_150;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {

    public static void main(String[] args) {
        Tree root = new Tree(5);

        root.left = new Tree(4);
        root.right = new Tree(8);
        root.left.left = new Tree(11);
        root.left.left.left = new Tree(7);
        root.left.left.right = new Tree(2);
        root.right.left = new Tree(13);
        root.right.right = new Tree(4);
        root.right.right.right = new Tree(1);

        System.out.println(hasPathSum(root,22));
    }

    private static boolean hasPathSum(Tree root, int target) {
        if (root == null) {
            return false;
        }

        Queue<Tree> queue = new LinkedList<>();
        Queue<Integer> pathSumQueue = new LinkedList<>();

        queue.offer(root);
        pathSumQueue.offer(root.value);

        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            int pathSum = pathSumQueue.poll();

            if (current.left == null && current.right == null &&
            pathSum == target) {
                return true;
            }

            if (current.left != null) {
                queue.offer(current.left);
                pathSumQueue.offer(pathSum + current.left.value);
            }

            if (current.right != null) {
                queue.offer(current.right);
                pathSumQueue.offer(pathSum + current.right.value);
            }
        }
        return false;
    }
}
