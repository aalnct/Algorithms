package restart.tree.easy;


public class SameBinaryTree {

    public static void main(String[] args) {
        Tree t1 = new Tree(1);
        t1.left = new Tree(2);
        t1.right = new Tree(3);

        Tree t2 = new Tree(1);
        t2.left = new Tree(2);
        t2.right = new Tree(3);

        System.out.println(isSameBinaryTree(t1,t2));
    }

    private static boolean isSameBinaryTree (Tree t1, Tree t2) {
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
