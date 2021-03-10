package fb;

import java.util.ArrayList;
import java.util.List;

public class LeafPathSum2 {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

        int target = 22;

        List<List<Integer>> list = leafPathSum(node,target);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static List<List<Integer>> leafPathSum (TreeNode node, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        list = helper(node,target,list);

        result.add(list);

        return result;
    }

    static List<Integer> helper (TreeNode node, int target, List<Integer> list) {
        if (node == null) {
            return list;
        }
        list.add(node.data);
        if (node.left != null) {
            helper(node.left,target - node.data,list);
        }

        if (node.right != null) {
            helper(node.right,target - node.data,list);
        }

        /*if(node.left == null && node.right == null && (target - node.data == 0)) {
            list = new ArrayList<>();
        }*/

        return list;
    }
}
