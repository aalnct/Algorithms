package fb;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsBinaryTree {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode (int val) {this.val = val;}
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        boolean isCousin = isCousins(node,4,7);
        System.out.println(isCousin);
    }

    static boolean isCousins (TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int pX = 0;
            int pY = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left !=null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        pX = node.val;
                    }
                    if (node.left.val == y) {
                        pY = node.val;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        pX = node.val;
                    }
                    if (node.right.val == y) {
                        pY = node.val;
                    }
                }

                if (pX != 0 && pY != 0) {
                    return (pX != 0 && pY != 0 && pX != pY);
                }

            }
        }

        return false;
    }


}
