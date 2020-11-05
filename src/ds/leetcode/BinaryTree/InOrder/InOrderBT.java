package ds.leetcode.BinaryTree.InOrder;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class InOrderBT {

    public Node root;

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println("Key :" + node.key);
        inOrder(node.left);
        inOrder(node.right);
    }

    public void printInOrder(){
        inOrder(root);
    }
}
