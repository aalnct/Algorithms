package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePrintRightSide {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode () {}

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(4);
        List<Integer> list = printRightSide(node);
        list.forEach(System.out::println);
    }

    static List<Integer> printRightSide (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = new TreeNode();

            for (int i=0; i<size; i++ ) {
                node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(node.val);
        }

        return list;
    }
}
