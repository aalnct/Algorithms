package restart.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

class PathSumTree {
    int value;
    PathSumTree left;
    PathSumTree right;

    public PathSumTree (int value) {
        this.value = value;
    }
}

public class PathSum {

    public static void main(String[] args) {
        PathSumTree root = new PathSumTree(5);

        root.left = new PathSumTree(4);
        root.right = new PathSumTree(8);
        root.left.left = new PathSumTree(11);
        root.left.left.left = new PathSumTree(7);
        root.left.left.right = new PathSumTree(2);
        root.right.left = new PathSumTree(13);
        root.right.right = new PathSumTree(4);
        root.right.right.right = new PathSumTree(1);

        System.out.println(hasPathSum(root,22));

    }

    static boolean hasPathSum (PathSumTree node, int targetSum) {
        if (node == null) {
            return false;
        }

        Queue<PathSumTree> queue = new LinkedList<>();
        Queue<Integer> pathSum = new LinkedList<>();

        queue.offer(node);
        pathSum.offer(node.value);

        while (!queue.isEmpty()) {
            PathSumTree current = queue.poll();
            int sum = pathSum.poll();

            if (current.left == null && current.right == null && sum == targetSum) {
                return true;
            }

            if (current.left != null) {
                queue.offer(current.left);
                pathSum.offer(sum + current.left.value);
            }

            if (current.right != null) {
                queue.offer(current.right);
                pathSum.offer(sum + current.right.value);
            }
        }
        return false;
    }
}
