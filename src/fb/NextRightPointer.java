package fb;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointer {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        TreeNode outputNode = nextRightPointer(node);
        System.out.println(outputNode.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    static TreeNode nextRightPointer (TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prevNode = null;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (prevNode!=null) {
                    prevNode.next = node;
                }
                prevNode = node;
            }
        }
        return root;
    }
}
