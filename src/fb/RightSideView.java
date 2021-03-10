package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RightSideView {

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
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(4);

        List<List<Integer>> list = rightSideView(node);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static List<List<Integer>> rightSideView(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode element = stack.pop();
            list.add(element.data);

            if (element.right!=null) {
                stack.push(element.right);
            }
        }
        result.add(list);

        return result;
    }
}
