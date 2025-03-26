package restart.graph.again.graphtheory.bfs;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;

    BinaryTree (int val) {
        this.val = val;
    }
}
public class LevelOrderTraversalBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        printLevelOrderTraversal(root);
    }

    static void printLevelOrderTraversal (BinaryTree root) {
        if (root == null) return;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        int currLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Current Level ::" + currLevel);
            for (int i=0;  i <size; i++) {
                BinaryTree curr = queue
                        .poll();
                System.out.println(" current node values " + curr.val);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            currLevel++;
        }
    }
}
