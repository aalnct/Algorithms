package binarysearchtree;

/**
 * Created by AmitAgarwal on 3/28/19.
 */
public class Application {

    public static void main(String[] args){
        BST tree = new BST();
        tree.insert(10,"ten");
        tree.insert(55,"twenty");
        tree.insert(15,"hundred");

        System.out.println(tree.findMin().key);
        System.out.println(tree.findMax().key);
    }

}
