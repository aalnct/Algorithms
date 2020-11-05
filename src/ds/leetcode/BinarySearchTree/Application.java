package ds.leetcode.BinarySearchTree;

/**
 * Created by AmitAgarwal on 5/20/20.
 */
public class Application {

    public static void main(String [] args){
        BST bst = new BST();
        bst.insertNode(20,"ten");
        bst.insertNode(10,"twenty");
        bst.insertNode(15,"Fifteen");

        bst.insertNode(18,"Fifteen");
        bst.insertNode(1,"Fifteen");
        bst.insertNode(12,"Fifteen");

        System.out.println("minimum element is : " + bst.findMin().key);
        System.out.println("maximum element is : " + bst.findMax().key);
    }
}
