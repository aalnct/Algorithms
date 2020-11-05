package ds.leetcode.BinarySearchTree.balancetree;

/**
 * Created by AmitAgarwal on 6/3/20.
 */

class Tree {
    public int data;

    public Tree left,right;

    public Tree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class BalancedBinaryTree {

    public Tree root;


    public boolean isBalanced(Tree node){
        int lh;
        int rh;

        if(node == null){
            return true;
        }

        // get the height
        lh = height(node.left);
        rh = height(node.right);

        if(Math.abs(lh-rh) <=1 && isBalanced(node.left) && isBalanced(node.right)){
            return true;
        }else {
            return false;
        }
    }

    private int height(Tree node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left) ,  height(node.right));
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        bbt.root = new Tree(1);
        bbt.root.left = new Tree(2);
        bbt.root.right = new Tree(3);
        bbt.root.left.left = new Tree(4);
        bbt.root.left.right = new Tree(5);
        bbt.root.left.left.left = new Tree(8);

        if(bbt.isBalanced(bbt.root)) {
            System.out.println("Balanced");
        }else {
            System.out.println("not Balanced");
        }
    }
}
