package restart.tree.medium;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode (int value) {
        this.value = value;
    }
}

public class InOrderSuccessorBST {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        TreeNode p = new TreeNode(1);

        System.out.println(inOrderSuccessor(node,p).value);
    }

    private static TreeNode inOrderSuccessor(TreeNode node, TreeNode p) {
        TreeNode successor = null;

        while (node != null) {
            if (p.value < node.value) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }
}
