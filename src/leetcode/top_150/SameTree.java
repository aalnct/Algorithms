package leetcode.top_150;

public class SameTree {

    public static void main(String[] args) {
        Tree p = new Tree(1);
        p.left = new Tree(2);
        p.right = new Tree(3);

        Tree q = new Tree(1);
        q.left = new Tree(2);
        q.right = new Tree(3);

        System.out.println(isSameTree(p,q));
    }

    private static boolean isSameTree (Tree p, Tree q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.value != q.value) {
            return false;
        }

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
