package fb;

public class BinaryTreeDiameter {

    static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;

        BinaryTree (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);

        System.out.println(diameter(tree));
    }

    static int diameter (BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        int leftHeight = height (tree.left);
        int rightHeight = height (tree.right);

        int leftDiameter = diameter(tree.left);
        int rightDiameter = diameter(tree.right);

        return Math.max(leftHeight + rightHeight,
                Math.max(leftDiameter,rightDiameter));
    }

    static int height (BinaryTree tree) {
        if (tree == null) return 0;

        return (1 + Math.max(height(tree.left),
                height(tree.right)));
    }
}
