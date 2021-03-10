package fb;

public class ArrayToBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,6,6,6};
        TreeNode node = new TreeNode();
        arrayToBT(array,node,0);
    }

    static TreeNode arrayToBT(int [] array, TreeNode node, int i) {
        // base case of recursion
        if (i < array.length) {
            TreeNode temp = new TreeNode();
            node = temp;

            node.left = arrayToBT(array,node.left, 2*i+1);
            node.right = arrayToBT(array,node.right, 2*i+2);
        }
        return node;
    }
}
