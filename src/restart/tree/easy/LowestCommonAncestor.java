package restart.tree.easy;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(3);
        root.left = new TreeNode1(5);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(6);
        root.left.right = new TreeNode1(2);
        root.right.left = new TreeNode1(0);
        root.right.right = new TreeNode1(8);
        root.left.right.left = new TreeNode1(7);
        root.left.right.right = new TreeNode1(4);


        System.out.println(lowestCommonAncestor(root,root.left, root.right).value);
    }

    private static TreeNode1 lowestCommonAncestor (TreeNode1 root, TreeNode1 p, TreeNode1 q) {
        if (root ==null || root == p || root == q) {
            return root;
        }

        TreeNode1 leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode1 rightTree = lowestCommonAncestor(root.right,p,q);

        if (leftTree != null && rightTree != null) {
            return root;
        }

        return leftTree != null ? leftTree : rightTree;
    }
}
