package restart.tree.easy;


public class SubTreePreOrder {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        TreeNode sub = new TreeNode(1);
        sub.left = new TreeNode(2);
        sub.right = new TreeNode(5);

        System.out.println(isSubTree(node,sub));
    }

    private static String preOrderTraversal(TreeNode node) {
        if (node == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder("^");
        sb.append(node.value);
        sb.append(preOrderTraversal(node.left));
        sb.append(preOrderTraversal(node.right));

        return sb.toString();
    }

    private static boolean isSubTree (TreeNode root, TreeNode subRoot) {
        String fullTree = preOrderTraversal(root);
        String subTree = preOrderTraversal(subRoot);

        return fullTree.contains(subTree);
    }
}
