package restart.tree.easy;

class TreeNode {
    int value;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class DiameterBinaryTree {

    static int diameter = 0;

    public static void main(String[] args) {
        TreeNode1 tree = new TreeNode1(1);
        tree.left = new TreeNode1(2);
        tree.right = new TreeNode1(3);
        tree.left.left = new TreeNode1(4);
        tree.left.right = new TreeNode1(5);

        int result = diameterBinaryTree(tree);
        System.out.println(result);
    }

    private static int diameterBinaryTree (TreeNode1 tree) {
        calculate(tree);
        return diameter;
    }

    private static int calculate (TreeNode1 tree) {
        if (tree == null) return 0;

        int leftDepth = calculate(tree.left);
        int rightDepth = calculate(tree.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth,rightDepth);
    }

}
