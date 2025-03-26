package restart.tree.easy;

class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;

    BinaryTree (int val) {
        this.val = val;
    }

}
public class RangeSumBST {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(5);
        root.right = new BinaryTree(15);
        root.left.left = new BinaryTree(3);
        root.left.right = new BinaryTree(7);
        root.right.right = new BinaryTree(18);

        System.out.println(rangeSumBST(root,7,15));
    }

    static int rangeSumBST (BinaryTree root, int low, int high) {
        // have to add the numbers falling in range in a binary search tree
        // both inclusive

        if (root == null) {
            return 0;
        }

        // using DFS approach
        if (root.val < low) {
            return rangeSumBST(root.right, low,high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left,low,high);
        }

        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right, low,high);
    }
}
