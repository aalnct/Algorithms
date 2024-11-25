package leetcode.top_150;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        invertBinaryTree(root);
    }

    private static void invertBinaryTree (Tree root) {
        if (root == null) {
            return;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            System.out.print(current.value + " ");

            Tree temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
            System.out.println(" ");
        }

    }
}
