package binarysearchtree_2;

public class BinarySearchTree {

    public Node root; // actual root implementation for binary tree

    public void insertData (int key, String data) {
        Node newNode = new Node(key,data);

        if (root == null) {
            root = newNode;
        } else {
            // where will we insert the data
            // smaller - then the current - left
            // bigger - than the current - right

            Node currentNode = root;
            Node parent;

            while (true) {
                parent = currentNode; // maintain the reference since it will be needed when inserting data....
                if (key < currentNode.key) {
                    // go to left
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    // min will be available at the left side of tree....
    public Node findMin () {
        Node current = root;
        Node value = null;
        while (current!=null) {
            value = current;
            current = current.left;
        }
        return value;
    }

    // max will be available on right side of the tree.....
    public Node findMax () {
        Node current = root;
        Node value = null;
        while (current != null) {
            value = current;
            current = current.right;
        }
        return value;
    }

}
