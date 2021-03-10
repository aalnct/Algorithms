package fb;

public class BinaryTreeToDLL {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
        }
    }

    static Node headLinkedList;
    static Node prev;

    public static void main(String[] args) {

    }

    static void bstToDLL (Node node) {
        if (node == null) {
            return;
        }

        bstToDLL(node.left);

        if (prev == null) {
            headLinkedList = node;
            prev = node;
        } else {
            node.left = prev;
            prev.right = node;
            prev = node;
        }

        bstToDLL(node.right);

    }
}
