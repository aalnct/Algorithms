package restart.tree.easy;

class Tree {
    int value;
    Tree left;
    Tree right;

    public Tree(int value) {
        this.value = value;
    }
}

public class DiameterBinaryTree {

    static int diameter = 0;

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);

        int result = diameterBinaryTree(tree);
        System.out.println(result);
    }

    private static int diameterBinaryTree (Tree tree) {
        calculate(tree);
        return diameter;
    }

    private static int calculate (Tree tree) {
        if (tree == null) return 0;

        int leftDepth = calculate(tree.left);
        int rightDepth = calculate(tree.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth,rightDepth);
    }

}
