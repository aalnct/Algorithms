package fb;

public class LeafPathSum {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode (int data) {
            this.data = data;
        }

        TreeNode () { }
    }

    public static void main(String[] args) {
        short target = 13;
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(11);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        boolean result = hasPathSum(node,target);
        System.out.println(result);

        node = new TreeNode();
        result = hasPathSum(node,target);
        System.out.println(result);
    }

    static boolean hasPathSum (TreeNode node, int target) {
        if (node == null) {
            return target == 0;
        }

        if (node.left == null && node.right == null && target == 0) {
            return false;
        }

        return hasPathSum(node.left, target - node.data) ||
        hasPathSum(node.right, target - node.data);
    }
}
