package restart.gemini.binarytree;

class BinaryNode {
    int value;
    BinaryNode left,right;

    public BinaryNode (int value) {
        this.value = value;
    }
}
public class LowestCommonAncestor {

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(3);
        root.left = new BinaryNode(5);
        root.right = new BinaryNode(1);
        root.left.left = new BinaryNode(6);
        root.left.right = new BinaryNode(2);
        root.right.left = new BinaryNode(0);
        root.right.right = new BinaryNode(8);
        root.left.right.left = new BinaryNode(7);
        root.left.right.right = new BinaryNode(4);

        System.out.println(lca(root,root.left, root.right).value);
    }

    static BinaryNode lca(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        BinaryNode left = lca(root.left,p,q);
        BinaryNode right = lca(root.right,p,q);

        if (left != null && right != null) {
           return root;
        }

        return left != null ? left : right;
    }
}
