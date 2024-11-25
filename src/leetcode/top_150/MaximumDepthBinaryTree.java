package leetcode.top_150;

class Tree {
    int value;
    Tree left;
    Tree right;

    public Tree(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}
public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree(3);
        tree.left = new Tree(9);
        tree.right = new Tree(20);
        tree.right.left = new Tree(15);
        tree.right.right = new Tree(7);

        int depth = maxDepth(tree);
        System.out.println(depth);
    }

    public static int maxDepth(Tree root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight , rightHeight)+1;
    }

    private static int getHeight (Tree tree) {
        if (tree == null) {
            return 0;
        }

        int left = getHeight(tree.left);
        int right = getHeight(tree.right);

        return Math.max(left,right) + 1;
    }

}
