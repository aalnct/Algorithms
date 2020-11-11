package binarysearchtree_2;

public class Application {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertData(10,"ten");
        binarySearchTree.insertData(20,"twenty");
        binarySearchTree.insertData(30,"thirty");

        System.out.println("Finding the minimum value :" + binarySearchTree.findMin().key);
        System.out.println("Finding the maximum value :" + binarySearchTree.findMax().key);
    }
}
