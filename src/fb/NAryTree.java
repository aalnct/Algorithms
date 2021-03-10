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
        tree.children = new ArrayList<>();
        tree.children.add(tree);
    }

    static List<List<Integer>> naryTreePrint () {
        return null;
    }
}
