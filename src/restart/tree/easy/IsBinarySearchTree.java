package restart.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class IsBinarySearchTree {

    public static void main(String[] args) {
        TreeNode1 tree = new TreeNode1(5);
        tree.left = new TreeNode1(1);
        tree.right = new TreeNode1(4);
        tree.right.left = new TreeNode1(3);
        tree.right.right = new TreeNode1(6);

        System.out.println(isBST(tree));
    }

    // solution using InOrder Traversal
    static boolean isBST (TreeNode1 root) {
        List<Integer> list = new ArrayList<>();

        // need to element of tree into list
        helper(root, list);

        int prev = list.get(0);

        for (int i=1; i < list.size(); i++) {
            if (list.get(i) <= prev) {
                return false;
            }
            prev = list.get(i);
        }
        return true;
    }

    static void helper (TreeNode1 root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left,list);
        list.add(root.value);
        helper(root.right,list);
    }

}
