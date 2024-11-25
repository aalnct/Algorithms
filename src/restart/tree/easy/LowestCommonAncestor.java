package restart.tree.easy;

public class LowestCommonAncestor {

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


        System.out.println(lowestCommonAncestor(root,root.left, root.right).value);
    }

    private static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root ==null || root == p || root == q) {
            return root;
        }

        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);

        if (leftTree != null && rightTree != null) {
            return root;
        }

        return leftTree != null ? leftTree : rightTree;
    }
}
