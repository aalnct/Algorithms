package restart.dynamicprogramming.medium;

import java.util.Arrays;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode () {}
    public TreeNode (int value) {
        this.value = value;
        this.left  = null;
        this.right = null;
    }
}
public class HouseRobber3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));

    }

    static int [] houseRobberHelper (TreeNode root) {
        if (root == null) {
            return new int [] {0,0};
        }

        int [] left = houseRobberHelper(root.left);
        int [] right = houseRobberHelper(root.right);

        int robCurrent = root.value + left[1] + right[1];

        int doNotRobCurrent = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int [] {robCurrent,doNotRobCurrent};
    }

    static int rob (TreeNode root) {
        int [] result = houseRobberHelper(root);
        return Math.max(result[0],result[1]);
    }

}
