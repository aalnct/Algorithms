package binarysearchtree;

/**
 * Created by AmitAgarwal on 3/28/19.
 */
public class BST {

    /**
     * creating root node
     */

    private Node root;

    public void insert(int key, String value) {

        /**
         * to instantiate root
         */

        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode; //so if root is null, then initialize it with the current value
        } else {
            //if root is not null

            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) {//parent is leaf node
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }

        }

    }

    public Node findMin(){ //finding minimum in BST - always go to left
        Node current = root;
        Node last = null;

        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax(){ //to find max, traverse the right child
        Node current = root;
        Node last = null;
        while(current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    /**
     * to remove a particular node - delete using a key (which one to delete)
     */
    public boolean deleteNode(int key){
        Node currentNode = root;
        Node parentNode = null;
        boolean foundNode = false;
        boolean isLeftChild = false;
        //searching for the key to delete
        while(key != currentNode.key){
            parentNode = currentNode; //??
            if(key < currentNode.key){
                isLeftChild = true; //if passed key is less than current node value, than need to traverse the left child
                currentNode = currentNode.leftChild;
            }else{
                currentNode = currentNode.rightChild;
                isLeftChild = false; //since key is more than or equal than need to travers the right child
            }
            if(currentNode == null){
                    return foundNode;
            }
        }

        //found the node
        Node nodeToDelete = currentNode;
        //if node is leaf
        if(nodeToDelete.leftChild == null && nodeToDelete.rightChild ==null){
            if(nodeToDelete == root){
                root = null;
            }
            else if(isLeftChild){
                parentNode.leftChild = null;
            }else{
                parentNode.rightChild = null;
            }
        }
        //if node to delete has one child that is left
        else if(nodeToDelete.rightChild == null){
            if(nodeToDelete == root){
                root = nodeToDelete.leftChild;
            }else if(isLeftChild){
                parentNode.leftChild = nodeToDelete.leftChild;
            }else{
                parentNode.rightChild = nodeToDelete.leftChild;
            }
        }
        //if node to delete has one child that is right
        else if(nodeToDelete.leftChild == null){
            if(nodeToDelete == root){
                root = nodeToDelete.rightChild;
            }else if(isLeftChild){
                parentNode.leftChild = nodeToDelete.rightChild;
            }else{
                parentNode.rightChild = nodeToDelete.rightChild;
            }
        }

        //if node has 2 children
        else{

        }
        return true;
    }
}
