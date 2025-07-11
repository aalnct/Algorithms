package restart.tree.easy;

class Tree1 {
    int value;
    Tree1 left;
    Tree1 right;

    public Tree1 (int value) {
        this.value = value;
    }
}

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Tree1 tree = new Tree1(1);
        tree.left = new Tree1(2);
        tree.right = new Tree1(3);
        tree.left.left = new Tree1(4);
        tree.left.right = new Tree1(5);

        System.out.println(isBalance(tree));
    }

    private static boolean isBalance (Tree1 root) {
        return checkHeight(root) != -1; // if true, then tree is balance
    }

    private static int checkHeight (Tree1 root) {
        if (root  == null) {
            return 0; // anyway it is balance if root is null
        }

        int leftHeight = checkHeight(root.left);

        if (leftHeight == -1) {
            return -1; // not balanced tree
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1; // not balanced tree
        }

        if (Math.abs(leftHeight - rightHeight ) > 1) {
            return -1; // cannot be more than 1 for the tree to be balanced
        }

        return Math.max(leftHeight,rightHeight) + 1;
    }
}
