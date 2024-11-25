package restart.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTRightSide {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // 1,3,4
        rightSideView(root).forEach(System.out::println);
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode current = null;
            for (int i=0; i < levelSize; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.right);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (current != null) {
                list.add(current.value);
            }
        }
        return list;
    }
}
