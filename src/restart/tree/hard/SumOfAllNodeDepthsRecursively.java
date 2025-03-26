package restart.tree.hard;

public class SumOfAllNodeDepthsRecursively {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.right.left = new BinaryTree(6);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        System.out.println(sumOfAllDepths(root));
    }

    static int sumOfAllDepths (BinaryTree root) {
        if (root == null) return 0;
        return sumOfAllDepths(root.left) + sumOfAllDepths(root.right) +
                nodeDepth(root,0); // this nodeDepth is for each node acting as root for its subtree
    }

    static int nodeDepth (BinaryTree node, int depth) {
       if (node == null) return 0;

       return depth + nodeDepth(node.left , depth + 1) +
               nodeDepth(node.right, depth + 1);
    }
}