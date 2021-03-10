package fb;

public class IsBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        /*Node node = new Node(20);
        node.left = new Node(15);
        node.right = new Node(23);
        node.left.left = new Node(12);
        node.left.right = new Node(18);
        node.right.left = new Node(22);
        node.right.right = new Node(21);*/

        Node node = new Node(300);
        node.left = new Node(200);
        node.right = new Node(400);
        node.left.left = new Node(100);
        node.right.right = new Node(400);

        System.out.println(isBST(node));
    }

    static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        if(node.left != null) {
            if (node.left.data > node.data) {
                return false;
            }
        }
        if (node.right !=null) {
            if (node.right.data < node.data) {
                return false;
            }
        }

       return  isBST(node.left) &&  isBST(node.right);
    }
}
