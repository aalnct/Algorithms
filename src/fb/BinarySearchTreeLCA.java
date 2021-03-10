package fb;

public class BinarySearchTreeLCA {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(8);
        node.right = new Node(22);
        node.left.left = new Node(4);
        node.left.right = new Node(12);
        node.left.right.left = new Node(10);
        node.left.right.right = new Node(14);

        Node t = lcaBinaryTree(node,node.left.right.left,node.left.right.right);
        System.out.println(t.data);
    }

    static Node lcaBinaryTree (Node node, Node p1, Node p2) {
        if (node == null) {
            return null;
        }

        if (node.data > p1.data && node.data > p2.data) {
            return lcaBinaryTree(node.left,p1,p2);
        }

        if (node.data < p1.data && node.data < p2.data) {
            return lcaBinaryTree(node.right, p1, p2);
        }

        return node;
    }


}
