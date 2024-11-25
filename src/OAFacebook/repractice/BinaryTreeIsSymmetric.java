package OAFacebook.repractice;

public class BinaryTreeIsSymmetric {

    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1(1);
        tree.left = new BinaryTree1(2);
        tree.right = new BinaryTree1(2);
        tree.left.left = new BinaryTree1(3);
        tree.left.right = new BinaryTree1(4);
        tree.right.left = new BinaryTree1(4);
        tree.right.right = new BinaryTree1(3);
        System.out.println(isSymmetric(tree));
    }

    static boolean isSymmetric (BinaryTree1 tree) {
        if (tree == null) {
            return true;
        }
        return isMirror(tree.left, tree.right);
    }
    private static boolean isMirror (BinaryTree1 left, BinaryTree1 right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.data == right.data) &&
                isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
