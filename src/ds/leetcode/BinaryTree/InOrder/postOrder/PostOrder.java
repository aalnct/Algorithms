package ds.leetcode.BinaryTree.InOrder.postOrder;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class PostOrder {
    public Node root;

    public void postOrderTree(Node node){
        if(node == null){
            return;
        }

        postOrderTree(node.left);
        postOrderTree(node.right);

        System.out.println("post order key : " + node.key);
    }

    public void printPostOrder(){
        postOrderTree(root);
    }
}
