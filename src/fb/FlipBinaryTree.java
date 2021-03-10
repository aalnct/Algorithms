package fb;

public class FlipBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

    }

    static Node flipUpsideDown (Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        Node oL = root.left;
        Node oR = root.right;

        Node flipped = flipUpsideDown(oL);

        Node newRoot = oL;
        newRoot.left = oR;
        newRoot.right = root;

        root.left = null;
        root.right = null;

        return flipped;
    }

}
