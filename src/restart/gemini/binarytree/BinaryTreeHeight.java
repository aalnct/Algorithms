package restart.gemini.binarytree;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class BinaryTree {
    int value;
    BinaryTree left, right ;

    public BinaryTree (int value) {
        this.value = value;
    }
}
public class BinaryTreeHeight {

    public static void main(String[] args) {
        BinaryTree node = new BinaryTree(1);
        node.left = new BinaryTree(2);
        node.right = new BinaryTree(3);
        node.left.left = new BinaryTree(4);
        node.left.right = new BinaryTree(5);
        node.right.left = new BinaryTree(6);
        node.right.right = new BinaryTree(7);

        System.out.println(heightUsingDFS(node));
        System.out.println(heightUsingBFS(node));
    }

    // dfs approach
    static int heightUsingDFS (BinaryTree root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightUsingDFS(root.left);
        int rightHeight = heightUsingDFS(root.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    static int heightUsingBFS (BinaryTree root) {
        if (root == null) {
            return 0;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                BinaryTree current = queue.poll();
                if (Objects.nonNull(current)) {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            height++;
        }
        return height;
    }

}
