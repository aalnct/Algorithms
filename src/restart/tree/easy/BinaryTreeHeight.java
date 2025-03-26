package restart.tree.easy;

public class BinaryTreeHeight {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);

        System.out.println(binaryTreeHeight(root));
    }

    static int binaryTreeHeight (TreeNode1 root) {
        if (root == null) {
            return 0;
        }

        int left = binaryTreeHeight(root.left);
        int right = binaryTreeHeight(root.right);

        return Math.max(left,right) + 1;
    }
}
