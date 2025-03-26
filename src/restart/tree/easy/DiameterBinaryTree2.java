package restart.tree.easy;

public class DiameterBinaryTree2 {
   static int maxDiameter = 0;

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);

        System.out.println(binaryTreeDiameter(root));
    }

    static int binaryTreeDiameter (TreeNode1 root) {
        height(root);
        return maxDiameter;
    }

    static int height(TreeNode1 root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left,right) + 1;
    }
}
