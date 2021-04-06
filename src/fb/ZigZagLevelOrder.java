package fb;

import java.util.*;

public class ZigZagLevelOrder {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode (int data) {
            this.data = data;
        }

        public static void main(String[] args) {
            TreeNode tree = new TreeNode(3);
            tree.left = new TreeNode(9);
            tree.right = new TreeNode(20);
            tree.right.left = new TreeNode(15);
            tree.right.right = new TreeNode(7);

            List<List<Integer>> result = zigZag(tree);
            result.forEach(System.out::print);
        }

        // 1st approach using 2 stack approach

        static List<List<Integer>> zigZagTraversal(TreeNode root) {
            List<Integer> list = null;
            List<List<Integer>> result = new ArrayList<>();
            Stack<TreeNode> currentStack = new Stack<>();
            Stack<TreeNode> nextStack = new Stack<>();
            currentStack.add(root);
            boolean leftToRight = true;

            while (!currentStack.isEmpty()) {
              list = new ArrayList<>();
              int size = currentStack.size();
              TreeNode node = currentStack.pop();
              for (int i=0; i< size; i++) {
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
                  list.add(node.data);
              }
              if (currentStack.isEmpty()) {
                  leftToRight = !leftToRight;
                  Stack<TreeNode> temp = currentStack;
                  currentStack = nextStack;
                  nextStack = temp;
              }
                result.add(new ArrayList<>(list));
            }
            return result;
        }
    }

    // 2nd approach using single queue

    public static List<List<Integer>> zigZag(TreeNode root) {
        List<Integer> list = null;
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean leftToRight = true;

        while (queue.size() > 0) {
            int size = queue.size();
            list = new ArrayList<>();
            TreeNode node = queue.poll();
            list.add(node.data);
            for (int i=0;i<size;i++) {
                if (leftToRight) {
                    if (node.left !=null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }
            }
            leftToRight = !leftToRight;
            result.add(list);
        }
        return result;
    }
}
