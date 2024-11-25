package OAOracle;

import java.util.LinkedList;
import java.util.Queue;

class BinaryNode {
    int value;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
    }
}
public class BinaryTreeHeight {

    public static void main(String[] args) {
        BinaryNode node = new BinaryNode(1);
        node.left = new BinaryNode(2);
        node.right = new BinaryNode(3);
        node.left.left = new BinaryNode(4);
        node.left.right = new BinaryNode(5);
        node.right.left = new BinaryNode(6);
        node.right.right = new BinaryNode(7);

        int h = height(node);
        System.out.println(h);

        System.out.println(checkHeight(node));
    }
    static int height (BinaryNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    static int checkHeight (BinaryNode node) {
        if (node == null) {
            return 0;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(node);
        int height = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();

            while (count > 0) {

                BinaryNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                count--;
            }
            height++;
        }
        return height;
    }
}
