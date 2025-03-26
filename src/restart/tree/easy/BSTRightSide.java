package restart.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTRightSide {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.right = new TreeNode1(5);
        root.right.right = new TreeNode1(4);

        // 1,3,4
        rightSideView(root).forEach(System.out::println);
    }

    private static List<Integer> rightSideView(TreeNode1 root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode1 current = null;
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
