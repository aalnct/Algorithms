package restart.tree.easy;


public class SameBinaryTree {

    public static void main(String[] args) {
        TreeNode1 t1 = new TreeNode1(1);
        t1.left = new TreeNode1(2);
        t1.right = new TreeNode1(3);

        TreeNode1 t2 = new TreeNode1(1);
        t2.left = new TreeNode1(2);
        t2.right = new TreeNode1(3);

        System.out.println(isSameBinaryTree(t1,t2));
    }

    private static boolean isSameBinaryTree (TreeNode1 t1, TreeNode1 t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.value != t2.value) {
            return false;
        }

        return isSameBinaryTree(t1.left,t2.left) && isSameBinaryTree(t2.right,t2.right);
    }

}
