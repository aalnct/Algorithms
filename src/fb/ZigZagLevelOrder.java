package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrder {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode (int data) {
            this.data = data;
        }

        public static void main(String[] args) {
            TreeNode tree = new TreeNode(1);
            tree.left = new TreeNode(2);
            tree.right = new TreeNode(3);
            tree.left.left = new TreeNode(7);
            tree.left.right = new TreeNode(6);
            tree.right.left = new TreeNode(5);
            tree.right.right = new TreeNode(4);

            zigZagTraversal(tree);
        }

        static void zigZagTraversal(TreeNode root) {
            Stack<TreeNode> currentStack = new Stack<>();
            Stack<TreeNode> nextStack = new Stack<>();
            currentStack.add(root);
            boolean leftToRight = true;

            while (!currentStack.isEmpty()) {
              TreeNode node = currentStack.pop();
                System.out.print(node.data + " ");
              if (leftToRight){
                  if (node.left != null) {
                      nextStack.push(node.left);
                  }
                  if (node.right != null) {
                      nextStack.push(node.right);
                  }
              } else {
                  if (node.right!=null) {
                      nextStack.push(node.right);
                  }
                  if (node.left != null) {
                      nextStack.push(node.left);
                  }
              }
              if (currentStack.isEmpty()) {
                  leftToRight = !leftToRight;
                  Stack<TreeNode> temp = currentStack;
                  currentStack = nextStack;
                  nextStack = temp;
              }
            }
        }
    }
}
