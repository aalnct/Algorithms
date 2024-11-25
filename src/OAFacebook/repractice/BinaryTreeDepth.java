package OAFacebook.repractice;

public class BinaryTreeDepth {
    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1(3);
        tree.left = new BinaryTree1(9);
        tree.right = new BinaryTree1(20);
        tree.right.left = new BinaryTree1(15);
        tree.right.right = new BinaryTree1(7);

        int height = findDepth(tree);
        System.out.println(height);
    }

    static int findDepth(BinaryTree1 tree) {
        if (tree == null) {
            return 0;
        }

        int leftHeight = getHeight(tree.left);
        int rightHeight = getHeight(tree.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    static int getHeight(BinaryTree1 tree) {
        if (tree == null) {
            return 0;
        }

        int left = getHeight(tree.left);
        int right = getHeight(tree.right);

        return Math.max(left,right)+1;
    }
}
