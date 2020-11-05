package ds.leetcode.BinarySearchTree.BinaryLCA;

/**
 * Created by AmitAgarwal on 6/7/20.
 */

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }

}

public class BinaryTreeLCA {

    public TreeNode root;

    public TreeNode findLCA(int x, int y){
        return findLCA(root,x,y);
    }

    public TreeNode findLCA(TreeNode root,int x, int y){
        if(root == null){
            return null;
        }
        if(root.data == x || root.data == y){
            return root;
        }

        TreeNode left = findLCA(root.left, x, y);
        TreeNode right = findLCA(root.right,x,y);

        // if both of the above nodes return non-null, then one node is present in one subtree,
        // and one is present in other subtree


        if(left != null && right!=null){
            return root;
        }

        return (left!=null ? left : right);
    }

    public static void main(String[] args) {
        BinaryTreeLCA bt = new BinaryTreeLCA();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        System.out.println("LCA for (4, 5)" + bt.findLCA(4,5).data);
    }
}
