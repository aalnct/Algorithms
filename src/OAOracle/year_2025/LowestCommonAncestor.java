package OAOracle.year_2025;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {
        this.val = val;
    }
}
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

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode lca = lowestCommonAncestor(root,p,q);
        System.out.println(lca.val);
    }

    static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode !=  null ? leftNode : rightNode;

    }
}
