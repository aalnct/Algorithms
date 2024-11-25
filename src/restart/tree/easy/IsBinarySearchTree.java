package restart.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class IsBinarySearchTree {

    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.left = new Tree(1);
        tree.right = new Tree(4);
        tree.right.left = new Tree(3);
        tree.right.right = new Tree(6);

        System.out.println(isBST(tree));
    }

    // solution using InOrder Traversal
    static boolean isBST (Tree root) {
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

    static void helper (Tree root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left,list);
        list.add(root.value);
        helper(root.right,list);
    }

}
