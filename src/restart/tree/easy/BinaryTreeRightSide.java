package restart.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSide {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(rightSideView(node));

    }

    static List<List<Integer>> rightSideView (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list =  new ArrayList<>();
            for (int i=0; i < size; i++) {
                TreeNode current = queue.poll();
                list.add(current.value);
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
