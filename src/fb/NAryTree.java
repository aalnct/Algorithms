package fb;

import java.util.ArrayList;
import java.util.List;

public class NAryTree {

    static class TreeNode {
        int data;
        List<TreeNode> children;

        TreeNode (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        TreeNode tree1 = new TreeNode(3);
        TreeNode tree2 = new TreeNode(3);
        TreeNode tree3 = new TreeNode(3);
        tree.children = new ArrayList<>();
        tree.children.add(tree);
        tree.children.add(tree1);
        tree.children.add(tree2);
        tree.children.add(tree3);
    }

    static List<List<Integer>> naryTreePrint () {
        return null;
    }
}
