package restart.tree.easy;

public class BinaryTreeGoodNode {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(5);

        System.out.println(goodNodeCount(node));
    }

    static  int goodNodeCount (TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }

    static int dfs(TreeNode root, int minValue) {
        if (root == null) {
            return 0;
        }
        int goodNodeCount = 0;

        if (root.value >= minValue) {
            goodNodeCount++;
            minValue = root.value;
        }

        goodNodeCount += dfs(root.left,minValue);
        goodNodeCount += dfs(root.right,minValue);

        return goodNodeCount;
    }
}
