package ds.leetcode.BinaryTree.InOrder.binarytreesecondminimum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by AmitAgarwal on 6/16/20.
 */

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinarySecondMinimum {

    static TreeNode root;

    public static void main(String[] args) {
        findSecondMinimum(root);
    }

    // Depth First Search

    private static void dfs(TreeNode root, Set<Integer> unique){
        if(root != null){
            unique.add(root.data);
            dfs(root.left, unique);
            dfs(root.right, unique);
        }
    }

    public static int findSecondMinimum(TreeNode root) {
        Set<Integer> unique = new HashSet<>();
        dfs(root,unique);

        int min = root.data;
        long value = Long.MAX_VALUE;

        for(int v : unique){
            if(min < v && v < value){
                value = v;
            }
        }
        return value < Long.MAX_VALUE ? (int)value : -1;
    }

}
