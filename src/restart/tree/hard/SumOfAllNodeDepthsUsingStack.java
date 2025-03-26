package restart.tree.hard;

import java.util.Stack;

class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;

    BinaryTree (int val) {
        this.val = val;
    }
}
public class SumOfAllNodeDepthsUsingStack {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.right.left = new BinaryTree(6);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        System.out.println(sumOfAllNodeDepths(root));
    }

    // this approach solves it iteratively
    // time complexity O(nlog(n))
    // space complexity O(n)
    static int sumOfAllNodeDepths (BinaryTree root) {
        int sumOfAllDepths = 0;
        Stack<BinaryTree> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            BinaryTree currentNode = stack.remove(stack.size()-1); // since we are starting to remove from last element in tree instead
                                                                        // of first
            if (currentNode == null) {
                continue;
            }
            sumOfAllDepths += nodeDepth (currentNode,0);
            stack.add(currentNode.left);
            stack.add(currentNode.right);
        }

        return sumOfAllDepths;
    }

    static int nodeDepth (BinaryTree currentNode, int depth) {
        if (currentNode == null) return 0;

        return depth + nodeDepth(currentNode.left, depth + 1) +
                nodeDepth(currentNode.right, depth + 1);
    }
}