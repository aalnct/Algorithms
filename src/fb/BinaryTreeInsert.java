package fb;

public class BinaryTreeInsert {

    static Node root;

    static class Node {
        int key;
        Node left;
        Node right;

        Node (int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        insertIntoBinaryTree(10);
    }

    static void insertIntoBinaryTree (int key) {
        Node newNode = new Node(key);
        Node current = root;
        Node parent; // can I just use current for both left and right in place of parents node reference

        if (root == null) {
            root = newNode;
        } else {
            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
}
