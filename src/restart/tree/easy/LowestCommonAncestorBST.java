package restart.tree.easy;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode1 node = new TreeNode1(6);
        node.left = new TreeNode1(2);
        node.right = new TreeNode1(8);
        node.left.left = new TreeNode1(0);
        node.left.right = new TreeNode1(4);
        node.right.left = new TreeNode1(7);
        node.right.right = new TreeNode1(9);
        node.left.right.left = new TreeNode1(3);
        node.left.right.right = new TreeNode1(5);

        TreeNode1 p = node.left;
        TreeNode1 q = node.left.right;

        System.out.println(lca(node,p,q).value);
    }

    // using DFS approach
    static TreeNode1 lca(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
        if (root == null) {
            return root;
        }
        // root greater
        // root smaller
        // root is where path diverges , so return root
        if (root.value > p.value && root.value > q.value) {
            return lca(root.left,p,q);
        } else if (root.value < p.value && root.value < q.value) {
            return lca(root.right,p,q);
        } else {
            return root;
        }
    }
}
