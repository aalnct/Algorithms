package fb;

import java.util.Stack;

public class InorderIteration {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.data = data;
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

        inorderIterative(node);
    }

    static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current!=null || !stack.isEmpty()) {
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
            // set current as stack last item
            current = stack.pop();

            System.out.print( " " +current.data);

            // left is done, traverse right now
            current = current.right;
        }
    }
}
