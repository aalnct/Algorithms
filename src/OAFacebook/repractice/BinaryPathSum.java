package OAFacebook.repractice;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryPathSum {

    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1(5);
        tree.left = new BinaryTree1(4);
        tree.right = new BinaryTree1(8);
        tree.left.left = new BinaryTree1(11);
        tree.right.left = new BinaryTree1(13);
        tree.right.right = new BinaryTree1(4);
        tree.left.left.left = new BinaryTree1(7);
        tree.left.left.right = new BinaryTree1(2);

        System.out.println(binaryPathSum(tree,22));
    }

    // solving using Level Order traversal
    static boolean binaryPathSum (BinaryTree1 tree, int target) {
        if (tree == null) {
            return false;
        }

        Queue<BinaryTree1> queue = new LinkedList<>();
        Queue<Integer> pathSumQueue = new LinkedList<>();

        queue.offer(tree);
        pathSumQueue.offer(tree.data);

        while (!queue.isEmpty()) {
            BinaryTree1 current = queue.poll();
            int pathSum = pathSumQueue.poll();

            if (current.left == null && current.right == null
            && pathSum == target) {
                return true;
            }

            if (current.left != null) {
                queue.offer(current.left);
                pathSumQueue.offer(pathSum + current.left.data);
            }
            if (current.right != null) {
                queue.offer(current.right);
                pathSumQueue.offer(pathSum + current.right.data);
            }
        }
        return false;
    }
}
