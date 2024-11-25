package OAOracle;

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class CheckBST {

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(1);
        // tree.right = new Tree(30);
        // tree.left.left = new Tree(4);
        // tree.left.right = new Tree(5);

        System.out.println(checkBST(tree));
    }

    private static boolean checkBST(Tree node) {
        return isBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    static boolean isBST (Tree root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return isBST(root.left,min,root.data)
                && isBST(root.right,root.data,max);
    }
}
