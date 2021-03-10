package fb;

import java.util.Stack;

public class PreorderIterative {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        preorderIterative(node);
    }

    static void preorderIterative (TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek(); // 1
            System.out.print( " " +node.value);
            stack.pop(); // remove 1

            // adding right first, so it can be processed after left
            if(node.right != null) {
                stack.push(node.right);
            }

            if (node.left!=null) {
                stack.push(node.left);
            }

        }
    }
}
