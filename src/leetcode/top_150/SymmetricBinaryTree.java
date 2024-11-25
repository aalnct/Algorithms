package leetcode.top_150;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricBinaryTree {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right.left = new Tree(4);
        root.right.right = new Tree(3);

        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(Tree root) {
        if (root == null) {
            return true;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            Tree leftNode = queue.poll();
            Tree rightNode = queue.poll();

            if (leftNode == null && rightNode == null) {
                return true;
            }

            if(leftNode == null || rightNode == null
            || leftNode.value != rightNode.value) {
                return false;
            }

            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);

        }

        return true;
    }
}
