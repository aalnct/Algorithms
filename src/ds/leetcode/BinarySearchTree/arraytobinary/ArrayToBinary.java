package ds.leetcode.BinarySearchTree.arraytobinary;

/**
 * Created by AmitAgarwal on 6/17/20.
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

public class ArrayToBinary {

    public static void main(String[] args) {
        int [] nums = new int[] {-10,-3,0,5,9};
        TreeNode node = sortedArrayToBinary(nums);
        System.out.println(node.data + "" + node.left.data + "" + node.right.data);
    }

    public static TreeNode sortedArrayToBinary(int[] nums) {
        if(nums.length == 0) return null;
        return constructTreeFromArray(nums,0,nums.length-1);
    }

    private static TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if(left > right) return null;
        int pivot = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[pivot]);
        node.left = constructTreeFromArray(nums,left,pivot-1);
        node.right = constructTreeFromArray(nums,pivot+1,right);

        return node;
    }

}
