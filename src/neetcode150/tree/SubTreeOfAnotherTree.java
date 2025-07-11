package neetcode150.tree;

public class SubTreeOfAnotherTree {

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
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);

        System.out.println(isSubTree(root,subTree));
    }

    static boolean isSubTree (TreeNode root, TreeNode subTree) {
        if (root == null) {
            return false;
        }

        return isSameTree(root,subTree) || isSubTree(root.left,subTree)
                || isSubTree(root.right,subTree);
    }

    static boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q== null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
