package neetcode150.tree;


public class LowestCommonAncestor {

    static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;           // This IS the node 5 in the tree
        TreeNode q = root.left.right.right; // This IS the node 4 in the tree

        System.out.println(lca(root,p,q).val);
    }

    static TreeNode lca (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            System.out.println(" Root is null ::" + root);
            return null;
        }

        // if root is equal to any one node, then root is the answer
        if (root == p || root == q) {
            return root;
        }

        System.out.println(" Searching in left or right subtree");
        TreeNode leftNode = lca(root.left,p,q);
        TreeNode rightNode = lca(root.right,p,q);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode != null ? leftNode : rightNode;
    }
}
