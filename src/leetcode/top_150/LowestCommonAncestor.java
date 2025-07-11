package leetcode.top_150;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(5);
        root.right = new Tree(1);
        root.left.left = new Tree(6);
        root.left.right = new Tree(2);
        root.right.left = new Tree(0);
        root.right.right = new Tree(8);
        root.left.right.left = new Tree(7);
        root.left.right.right = new Tree(4);

        Tree p = root.left;
        Tree q = root.right;

        Tree lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.value);
    }

    private static Tree lowestCommonAncestor(Tree root, Tree p, Tree q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        Tree leftLCA = lowestCommonAncestor(root.left, p, q);
        Tree rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null || rightLCA != null) {
            return root;
        }
        return (leftLCA != null) ?  leftLCA : rightLCA;
    }
}
