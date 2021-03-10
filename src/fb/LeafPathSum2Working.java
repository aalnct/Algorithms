package fb;

import java.util.ArrayList;
import java.util.List;

public class LeafPathSum2Working {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

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
        pathSum (node,target);
    }

    public static List<List<Integer>> pathSum (TreeNode root, int target) {
        if (root == null)  return new ArrayList<>();
        helper (root,target,0);
        return result;
    }

    static void helper (TreeNode root, int target, int sum) {
        if (root == null) {
            return;
        }

        sum += root.data;
        list.add(root.data);

        if (root.left == null && root.right == null && sum == target) {
            result.add(list);
            list.remove(list.size()-1);
        }

        helper(root.left,target,sum);
        helper(root.right,target,sum);

//        for (int i = 0 ; i < list.size();i++) {
//            System.out.println(list.get(i));
//        }

        //

        return;
    }



}
