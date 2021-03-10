package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left  = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        postOrderIterative(node);
    }

    static void postOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();

        // adding root item into stack 1
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }



        while (!stack2.isEmpty()) {
            list.add(stack2.pop().data);
            //TreeNode temp = stack2.pop();
            //System.out.println(temp.data);
        }

        for (int ii : list) {
            System.out.print(" " + ii);
        }
    }
}
