package restart.tree.easy;


public class SubTreePreOrder {

    public static void main(String[] args) {
        TreeNode1 node = new TreeNode1(1);
        node.left = new TreeNode1(2);
        node.right = new TreeNode1(3);

        TreeNode1 sub = new TreeNode1(1);
        sub.left = new TreeNode1(2);
        sub.right = new TreeNode1(5);

        System.out.println(isSubTree(node,sub));
    }

    private static String preOrderTraversal(TreeNode1 node) {
        if (node == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder("^");
        sb.append(node.value);
        sb.append(preOrderTraversal(node.left));
        sb.append(preOrderTraversal(node.right));

        return sb.toString();
    }

    private static boolean isSubTree (TreeNode1 root, TreeNode1 subRoot) {
        String fullTree = preOrderTraversal(root);
        String subTree = preOrderTraversal(subRoot);

        return fullTree.contains(subTree);
    }
}
