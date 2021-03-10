package fb;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths2 {

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

        List<List<Integer>> result1 = printAllPaths(node);

        for (int i=0; i < result1.size(); i++) {
            System.out.println(result1.get(i));
        }
    }

    static List<List<Integer>> printAllPaths (TreeNode node) {
       // List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        helper (node, new ArrayList<>(),result);

        return result;
    }

    static void helper(TreeNode node, List<Integer> list, List<List<Integer>> result) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            list.add(node.data);
            result.add( new ArrayList<>(list));

            // remove current node from current path
            list.remove(list.size()-1);
            return;
        }

        list.add(node.data);

        helper(node.left,list,result);
        helper(node.right,list,result);

        list.remove(list.size()-1);

        return;
    }
}
