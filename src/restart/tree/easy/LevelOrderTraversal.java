package restart.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode1 node = new TreeNode1(3);
        node.left = new TreeNode1(9);
        node.right = new TreeNode1(20);
        node.right.left = new TreeNode1(15);
        node.right.right = new TreeNode1(7);

        levelOrderTraversal(node);
    }

    static void levelOrderTraversal (TreeNode1 root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode1 current = queue.poll();
                System.out.println(current.value);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }

}
