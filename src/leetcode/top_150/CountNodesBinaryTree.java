package leetcode.top_150;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodesBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        System.out.println(countNodes(tree));
    }

    private static int countNodes (Tree nodes) {
        int count = 0;
        if (nodes == null) {
            return 0;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(nodes);

        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            count++;

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return count;
    }
}
