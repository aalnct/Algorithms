package OAFacebook.repractice;

// Construct Binary Tree from InOrder and PostOrder traversal
public class ContructBTIOPO {

    public static void main(String[] args) {

    }

    static BinaryTree1 buildTree(int[] inOrder, int [] postOrder) {
        return buildTreeHelper(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length-1);
    }

    static BinaryTree1 buildTreeHelper (int[] inOrder, int inOrderStart, int inOrderEnd, int[] postOrder, int postStart, int postEnd) {
        if (inOrderStart > inOrderEnd || postStart > postEnd) {
            return null; // tree is empty
        }

        int rootValue = postOrder[postEnd]; // since in post order root value is last
        BinaryTree1 root = new BinaryTree1(rootValue);

        // find the index of the root in inOrder tree
        int inRootIndex = inOrderStart;
        while (inOrder[inRootIndex] != rootValue) {
            inRootIndex++;
        }

        // build left and right subtree ...
        int leftSubtreeSize = inRootIndex - inOrderStart;

        root.left = buildTreeHelper(inOrder, inOrderStart, inRootIndex - 1, postOrder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTreeHelper(inOrder, inRootIndex + 1, inOrderEnd, postOrder, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }
}
