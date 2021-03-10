package fb;

public class BinaryTreeLCA {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(18);
        node.right = new Node(20);
        node.left.left = new Node(11);
        node.left.right = new Node(31);
        node.left.right.left = new Node(2);
        node.right.left = new Node(5);
        node.right.left.left = new Node(7);
        node.right.right = new Node(9);
        node.right.right.right = new Node(6);

        Node n = findLCA(node,node.left.right.left,node.right.right.right);
        System.out.println(n.data);
    }

    static Node findLCA (Node node, Node p, Node q) {
        if (node == null) {
            return null;
        }

        if (node ==p || node == q) {
            return node;
        }

        Node leftLCA = findLCA(node.left, p, q);
        Node rightLCA = findLCA(node.right,p,q);

        if (leftLCA != null && rightLCA !=null) {
            return node;
        } else {
            return leftLCA !=null ? leftLCA : rightLCA;
        }
    }
}